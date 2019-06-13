import React from 'react';

import { Menu, Icon, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/classfication.css';
import {SelectNewsMain} from '../../config/router.js';
import {DeleteNewMain} from '../../config/router.js';
import {UpdateAnnounceFirst} from '../../config/router.js';
import {EventEmitter2} from 'eventemitter2';
import UpdateNews from './updateNews';
var emitter = new EventEmitter2()
var emitter2 = new EventEmitter2()

const id = -1;


class ShowTable extends React.Component{
  constructor(props) {
    super(props);
    this.tmp = this.tmp.bind(this);
   // this.changFirst = this.changFirst.bind(this);
    this.columns = [{
      title: '新闻标题',
      dataIndex: 'newsTitle',
      key: 'newsTitle',
    }, {
      title: '作者',
      dataIndex: 'createUser',
      key: 'createUser',
    }, {
      title: '创建时间',
      dataIndex: 'createDate',
      key: 'createDate',
    },  {
      title: '操作',
      key: 'action',
      render: (text, record) => (
        <span>
          <Popconfirm title="确定删除?" onConfirm={() => this.handleDelete(record.newsId)}>
            <a  href="javascript:;">删除</a>
          </Popconfirm>
          <Divider type="vertical" />
          <a href="javascript:;" onClick={()=>{this.tmp(record.newsId)}}>修改</a>
           </span>
       ),
    }];
  }
  tmp = (key) => {
    console.log("------ID："+key);
    emitter2.emit('changeShow', key);

  }
  
  handleDelete = (key) => {
    console.log('+++++++'+key)
      fetch(DeleteNewMain,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'newsId='+key

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  emitter.emit('changeFirstText', 'Second');
                }
                else {
                   window.alert(data.msg);
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

class AllNews extends React.Component{
  constructor(props) {
    super(props);
    this.state={
      nowPage: 1,
      totalPage: 1,
      pageSize: 10,
      newsAll: '',
      newsTitle: '',
    }
    this.newsTitleChange = this.newsTitleChange.bind(this);
    this.buttonClick = this.buttonClick.bind(this);
    emitter.on('changeFirstText', this.changeText.bind(this))
  }

  changeText( msg ){
    this.getClass();
  }
  componentWillMount() {
    this.getClass();
  }
  getClass() {
    fetch(SelectNewsMain, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'newsTitle='+this.state.newsTitle+'&pageNum='+this.state.nowPage+'&pageSize='+this.state.pageSize
    }).then( res=> res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({nowPage: data.resultBean.currentPage});
          this.setState({totalPage: data.resultBean.totalItems/data.resultBean.pageSize});
          this.setState({newsAll: data.resultBean.items});
        } else {
          this.setState({nowPage: 1});
          this.setState({totalPage: 1});
          this.setState({newsAll: ''});
        }
      }
    )
  }
  newsTitleChange(e) {
    this.setState({newsTitle: e.target.value});
  }
  pageChange = (page) => {
    console.log(page);
    this.setState({ nowPage: page }, () => this.getClass());
    
  }
  buttonClick() {
    this.getClass();
  }
  render() {
    return(
      <div style={{ flex: 1, padding: "10px" }}>
        <div className="title">
          <h3>新闻</h3>
        </div>
        <div className="searchF">
         <div className="example-input">
          <Input size="small" onChange={this.newsTitleChange} placeholder="目录名" style={{height:30 , width:150}}/>
          &nbsp;&nbsp;<Button type="primary" shape="circle" icon="search" onClick={this.buttonClick}/>
          </div>
        </div>
        <div className="search"> 
         <ShowTable classAll={this.state.newsAll}/>
        </div>
        <div className="searchPage">
        <Pagination size="small" simple onChange={this.pageChange} total={this.state.totalPage*this.state.pageSize} defaultCurrent={this.state.nowPage} showQuickJumper />
      </div>
      </div>
    );
  }
}
class ShowNews extends React.Component{
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
      sh = <AllNews />
    } else {
    console.log('id:'+this.state.id)
      sh = <UpdateNews newsId={this.state.id}/>
    }
    return(
      <div>
      {sh}
      </div>
    );
  }
}
export default ShowNews;