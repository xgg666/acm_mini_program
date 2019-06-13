import React from 'react';

import { Menu, Icon, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/classfication.css';
import {SelectAnnounce} from '../../config/router.js';
import {DeleteAnnounce} from '../../config/router.js';
import {UpdateAnnounceFirst} from '../../config/router.js';
import {EventEmitter2} from 'eventemitter2'
import Announcement from './announcement';
import UpdateAnnouncement from './updateAnnouncement';
var emitter = new EventEmitter2()
var emitter2 = new EventEmitter2()

const id = -1;

class First extends React.Component{
  constructor(props) {
    super(props);
  }
  render() {
    let ret;
    if (this.props.isFirst==1) {
      ret = <a  className="font-red">取消置顶</a>
    }
    else{
      ret = <a>置顶</a>
    }
    return(
      <span>{ret}</span>
    )
  }
}
class ShowTable extends React.Component{
  constructor(props) {
    super(props);
    this.tmp = this.tmp.bind(this);
    this.changFirst = this.changFirst.bind(this);
    this.columns = [{
      title: '公告名',
      dataIndex: 'announceTitle',
      key: 'announceTitle',
      render: (text, record) => (
        <span>
          {record.isPublic==1?<p>{text}</p>:<p>{text} -- 草稿</p>}
        </span>
       ),
    }, {
      title: '作者',
      dataIndex: 'announceCreateUser',
      key: 'announceCreateUser',
    }, {
      title: '创建时间',
      dataIndex: 'announceCreateTime',
      key: 'announceCreateTime',
    },  {
      title: '操作',
      key: 'action',
      render: (text, record) => (
        <span>
          <Popconfirm title="确定删除?" onConfirm={() => this.handleDelete(record.announceId)}>
            <a  href="javascript:;">删除</a>
          </Popconfirm>
          <Divider type="vertical" />
          <a href="javascript:;" onClick={()=>{this.tmp(record.announceId)}}>修改</a>
          <Divider type="vertical" />
          {record.isFirst==1?<a  className="font-red" onClick={()=>{this.changFirst(record.announceId)}}>取消置顶</a>:<a onClick={()=>{this.changFirst(record.announceId)}}>置顶</a>}
        </span>
       ),
    }];
  }
  tmp = (key) => {
    console.log("------"+key);
    emitter2.emit('changeShow', key);

  }
  changFirst = (announceId) => {
    console.log("------");
    fetch(UpdateAnnounceFirst,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'announceId='+announceId

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  emitter.emit('changeFirstText', 'Second');
                  alert('操作成功');
                }
                else {
                   alert(data.msg);
                }
            }
        )
  }
  handleDelete = (key) => {
    console.log('+++++++'+key)
      fetch(DeleteAnnounce,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'announceId='+key

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  emitter.emit('changeFirstText', 'Second');
                }
                else {
                   window.alert(data.code.msg);
                }
            }
        )
  }

  render() {
    return(
    <div>
      <Table columns={this.columns} dataSource={this.props.classAll} pagination={false} />
      
    </div>
    
    );
  }
}

class AllAnnounce extends React.Component{
  constructor(props) {
    super(props);
    this.state={
      nowPage: 1,
      totalPage: 1,
      pageSize: 10,
      announceAll: '',
      announceTitle: '',
    }
    this.announceTitleChange = this.announceTitleChange.bind(this);
    this.buttonClick = this.buttonClick.bind(this);
    this.getClass = this.getClass.bind(this);
    emitter.on('changeFirstText', this.changeText.bind(this))
  }

  changeText( msg ){
    this.getClass();
  }
  componentWillMount() {
    this.getClass();
  }
  getClass() {
    fetch(SelectAnnounce, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'announceTitle='+this.state.announceTitle+'&pageNum='+this.state.nowPage+'&pageSize='+this.state.pageSize
    }).then( res=> res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({nowPage: data.resultBean.currentPage});
          this.setState({totalPage: data.resultBean.totalItems/data.resultBean.pageSize});
          this.setState({announceAll: data.resultBean.items});
        } else {
          this.setState({nowPage: 1});
          this.setState({totalPage: 1});
          this.setState({announceAll: ''});
        }
      }
    )
  }
  announceTitleChange(e) {
    this.setState({announceTitle: e.target.value});
  }
  pageChange = (page) => {
    console.log(page);
    this.setState({ nowPage: page }, () => this.getClass());
    
  }
  buttonClick() {
    this.getClass();
  }
  render() {
    console.log(this.state.announceAll);
    return(
      <div style={{ flex: 1, padding: "10px" }}>
        <div className="title">
          <h3>公告</h3>
        </div>
        <div className="searchF">
         <div className="example-input">
          <Input size="small" onChange={this.announceTitleChange} placeholder="目录名" style={{height:30 , width:150}}/>
          &nbsp;&nbsp;<Button type="primary" shape="circle" icon="search" onClick={this.buttonClick}/>
          </div>
        </div>
        <div className="search"> 
         <ShowTable classAll={this.state.announceAll}/>
        </div>
        <div className="searchPage">
        <Pagination size="small" simple onChange={this.pageChange} total={this.state.totalPage*this.state.pageSize} defaultCurrent={this.state.nowPage} showQuickJumper />
      </div>
      </div>
    );
  }
}
class ShowAnnounce extends React.Component{
  constructor(props) {
    super(props);
    this.state={
      show: 1,
      id: 1,
    }
    emitter2.on('changeShow', this.changeShow.bind(this))
  }
  changeShow(cid) {
    if (this.state.show==1) {
      this.setState({show:0});
    } else {
      this.setState({show:1});
    }
    this.setState({id: cid})
  }
  render() {
    console.log('show:'+this.state.show)
    let sh;
    if (this.state.show==1) {
      sh = <AllAnnounce />
    } else {
    console.log('id:'+this.state.id)
      sh = <UpdateAnnouncement announceId={this.state.id}/>
    }
    return(
      <div>
      {sh}
      </div>
    );
  }
}
export default ShowAnnounce;