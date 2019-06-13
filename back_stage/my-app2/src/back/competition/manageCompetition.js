import React from 'react';

import { Menu, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm, message } from 'antd';
import cookie from 'react-cookies';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/classfication.css';
import {SelectCompetitionUrl} from '../../config/router.js';
import {DeleteCompetitionUrl} from '../../config/router.js';
import {DoneCompetitionUrl} from '../../config/router.js';
import {EventEmitter2} from 'eventemitter2'
import {ExportCompetition} from '../../config/router.js';
import Announcement from '../announce/announcement';
import UpdateAnnouncement from '../announce/updateAnnouncement';
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
    this.columns = [{
      title: '校赛名',
      dataIndex: 'competitionTitle',
      key: 'competitionTitle',
      render: (text, record) => (
        <span>
        <a href="javascript:;"><Link to={'/personCompetition/'+record.competitionId}>{record.competitionTitle}</Link></a>
          
           </span>
       ),
    }, {
      title: '创建人',
      dataIndex: 'createUser',
      key: 'createUser',
    }, {
      title: '比赛时间',
      dataIndex: 'createDate',
      key: 'createDate',
    }, {
      title: '创建时间',
      dataIndex: 'updateDate',
      key: 'updateDate',
    },  {
      title: '操作',
      key: 'action',
      render: (text, record) => (
        <span>
          <a href="javascript:;"><Link to={'/personCompetition/'+record.competitionId}>查看报名用户</Link></a>     
          <Divider type="vertical" />     
          <a  href={'http://localhost:9999/competition/export?competitionId='+record.competitionId}>导出报名名单</a>
          <Divider type="vertical" />
          <a href="javascript:;"><Link to={'/detailCompetition/'+record.competitionId}>修改</Link></a>
          <Divider type="vertical" />
          <Popconfirm title="确定删除?" onConfirm={() => this.handleDelete(record.competitionId)}>
            <a  href="javascript:;">删除</a>
          </Popconfirm>
        </span>
       ),
    },{
      title: '截至操作',
      key: 'stopaction',
      render: (text, record) => (
        <span>
          {
            record.isDone==1?<a href="javascript:;"><Tag color="#108ee9" onClick={()=>this.doneCompetition(record.competitionId, 0)}>截至报名</Tag></a>:
            <a href="javascript:;"><Tag color="#f50" onClick={()=>this.doneCompetition(record.competitionId, 1)}>恢复报名</Tag></a>
          }
          
          </span>
       ),
    }
    ];
  }

  handleExport = (id) => {
    fetch(ExportCompetition,{   //Fetch方法
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
     body: 'competitionId='+id

    }).then(res => res.json()).then(
        data => {
            if(data.code==0) {
              emitter.emit('changeFirstText', 'Second');
              message.success('导出成功');
            }
            else {
              message.error(data.msg);
            }
        }
    )  
  }
  doneCompetition = (key, mean) => {
    fetch(DoneCompetitionUrl,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'competitionId='+key+"&mean="+mean

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  emitter.emit('changeFirstText', 'Second');
                  message.success('操作成功');
                }
                else {
                   message.error(data.msg);
                }
            }
        )
  }
  tmp = (key) => {
    console.log("------"+key);
    emitter2.emit('changeShow', key);

  }
  handleDelete = (competitionId) => {
    console.log("------");
    fetch(DeleteCompetitionUrl,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'competitionId='+competitionId

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  emitter.emit('changeFirstText', 'Second');
                  message.success('操作成功');
                }
                else {
                   message.error(data.msg);
                }
            }
        )
  }
  

  render() {
    return(
    <div>
      <Table columns={this.columns} dataSource={this.props.competitionAll} pagination={false} />
      
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
      competitionAll: '',
      competitionTitle: '',
    }
    this.competitionTitleChange = this.competitionTitleChange.bind(this);
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
    //alert(this.state.competitionTitle);
    fetch(SelectCompetitionUrl, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'competitionTitle='+this.state.competitionTitle+'&pageNum='+this.state.nowPage+'&pageSize='+this.state.pageSize
    }).then( res=> res.json()).then(
      data => {
        if (data.code==0) {
          if(data.resultBean.currentPage>0) {
            this.setState({nowPage: data.resultBean.currentPage});
          }else {
            this.setState({nowPage: 1});
          }
          this.setState({totalPage: data.resultBean.totalItems/data.resultBean.pageSize});
          this.setState({competitionAll: data.resultBean.items});
        } else {
          this.setState({nowPage: 1});
          this.setState({totalPage: 1});
          this.setState({competitionAll: ''});
          message.error(data.msg);
        }
      }
    )
  }
  competitionTitleChange(e) {
    this.setState({competitionTitle: e.target.value}, ()=>this.getClass());
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
          <h3>校赛</h3>
        </div>
        <div className="searchF">
         <div className="example-input">
          <Input size="small" onChange={this.competitionTitleChange} placeholder="校赛名" style={{height:30 , width:150}}/>
          &nbsp;&nbsp;<Button type="primary" shape="circle" icon="search" onClick={this.buttonClick}/>
          </div>
        </div>
        <div className="search"> 
         <ShowTable competitionAll={this.state.competitionAll}/>
        </div>
        <div className="searchPage">
        <Pagination size="small" simple onChange={this.pageChange} total={this.state.totalPage*this.state.pageSize}
        pageSize={this.state.pageSize} defaultCurrent={this.state.nowPage} showQuickJumper />
      </div>
      </div>
    );
  }
}
class ShowCompetition extends React.Component{
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
export default ShowCompetition;