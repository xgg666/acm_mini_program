import React from 'react';

import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Menu, Button, Input, Select, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm, message, Modal } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import './static/my/css/classfication.css';
import {SelectUser} from '../config/router.js';
import {DeleteAnnounce} from '../config/router.js';
import {EventEmitter2} from 'eventemitter2'
import {SelectNewsMain} from '../config/router.js';
import {DeleteNewMain} from '../config/router.js';
import {UpdateAnnounceFirst} from '../config/router.js';
import {PassUser} from '../config/router.js';
import {NotPassUser} from '../config/router.js';
import {BeAdmin} from '../config/router.js';
import {BePlayer} from '../config/router.js';
import {UpdateUserInfo} from '../config/router.js';
import {DeleteUserInfo} from '../config/router.js';
import UserDetail from './userDetail';
import {UpdatePassword} from '../config/router.js';
import {ChangeUserAuth} from '../config/router.js';
var emitter = new EventEmitter2()
var emitter2 = new EventEmitter2()
const Option = Select.Option;

const id = -1;


class UpdateUser extends React.Component {
  state = { visible: false, passwordVisible: false }

  constructor(props) {
    super(props);

    this.state = {
      userId: this.props.classAll.userId,
      mobile: this.props.classAll.mobile,
      userName: this.props.classAll.username,
      studentId: this.props.classAll.studentId,
      grade: this.props.classAll.grade,
      realName: this.props.classAll.realname,
      classNum: this.props.classAll.classNum,
      auth: this.props.classAll.auth,
      password: "",
      passwordRepeat: "",
    };
    this.updateInfoClass = this.updateInfoClass.bind(this);
    this.updatePassword = this.updatePassword.bind(this);
    // this.changeUserAuth = this.changeUserAuth.bind(this);
  }

  showModal = () => {
    this.setState({
      visible: true,
    });
  }

  handleCancel = (e) => {
    this.setState({
      visible: false,
    });
  }

  showPasswordModal = () => {
    this.setState({
      passwordVisible: true,
    });
  }

  handlePasswordCancel = (e) => {
    this.setState({
      passwordVisible: false,
    });
  }

  mobileChange = (e) => {
    this.setState({mobile: e.target.value});
  }

  userNameChange = (e) => {
    this.setState({userName: e.target.value});
  }

  studentIdChange = (e) => {
    this.setState({studentId: e.target.value});
  }

  gradeChange = (e) => {
    this.setState({grade: e.target.value});
  }

  realNameChange = (e) => {
    this.setState({realName: e.target.value});
  }

  classNumChange = (e) => {
    this.setState({classNum: e.target.value});
  }

  passwordChange = (e) => {
    this.setState({password: e.target.value});
  }
  passwordRepeatChange = (e) => {
    this.setState({passwordRepeat: e.target.value});
  }

  updateInfoClass() {
    fetch(UpdateUserInfo, {
      method: 'POST',
      headers : {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body:'userId='+this.state.userId+'&username='+this.state.userName+"&realname="+this.state.realName+"&mobile="+this.state.mobile+"&studentId="+this.state.studentId+"&grade="+this.state.grade+"&classNum="+this.state.classNum
    }).then(res => res.json()).then(
      data => {
        if (data.code==0) {
          message.success('修改成功');
          emitter.emit('changeFirstText', '修改')
        } else {
          message.error(data.msg);
        }
      }
    )
  }

  updatePassword() {
    if (this.state.password != this.state.passwordRepeat) {
      alert('两次输入的密码不一致');
    } else {
      fetch(UpdatePassword, {
        method: 'POST',
        headers : {
          'Authorization': cookie.load('token'),
          'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body:'userId='+this.state.userId+'&password='+this.state.password
      }).then(res => res.json()).then(
        data => {
          if (data.code==0) {
            message.success('修改成功');
            emitter.emit('changeFirstText', '修改')
          } else {
            message.error(data.msg);
          }
        }
      )
    }
  }

  deleteClass() {
    fetch(DeleteUserInfo, {
      method: 'POST',
      headers : {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'userId='+this.state.userId
    }).then(res => res.json()).then(
      data => {
        if (data.code==0) {
          message.success('删除成功');
          emitter.emit('changeFirstText', '修改')
        } else {
          message.error(data.msg);
        }
      }
    )
  }

  render() {
    return (
      <span>
        <a href="javascript:;" onClick={this.showModal}>修改用户信息</a> 
        <Modal
          title="修改用户信息"
          visible={this.state.visible}
          onOk={this.updateInfoClass}
          onCancel={this.handleCancel}
          okText="确认修改"
          cancelText="返回"
        >
        <div align='center'>
          <img src={this.props.classAll.image} alt='头像'/>
        </div>
        <br/>
        <div align='center' style={{marginTop:10}}>
          手机号&nbsp;：<Input size="small" style={{height:30 , width:300}} 
          onChange={this.mobileChange} value={this.state.mobile}/>
        </div>
        <div  align='center' style={{marginTop:10}}>
          昵称&nbsp;&nbsp;：<Input size="small" style={{height:30 , width:300}} 
          onChange={this.userNameChange} value={this.state.userName}/>
        </div>
        <div  align='center' style={{marginTop:10}}>
          学号&nbsp;&nbsp;：<Input size="small" style={{height:30 , width:300}} 
          onChange={this.studentIdChange} value={this.state.studentId}/>
        </div>
        <div  align='center' style={{marginTop:10}}>
          年级&nbsp;&nbsp;：<Input size="small" style={{height:30 , width:300}} 
          onChange={this.gradeChange} value={this.state.grade}/>
        </div>
        <div  align='center' style={{marginTop:10}}>
          班级&nbsp;&nbsp;：<Input size="small" style={{height:30 , width:300}} 
          onChange={this.classNumChange} value={this.state.classNum}/>
        </div>
        <div  align='center' style={{marginTop:10}}>
          真实姓名：<Input size="small" style={{height:30 , width:300}}
          onChange={this.realNameChange} value={this.state.realName}/>
        </div>
        </Modal>
        <Divider type="vertical" />
        <a href="javascript:;" onClick={this.showPasswordModal}>修改密码</a> 
        <Modal
          title="修改密码"
          visible={this.state.passwordVisible}
          onOk={this.updatePassword}
          onCancel={this.handlePasswordCancel}
          okText="确认修改"
          cancelText="返回"
        >
          <div>
            请输入新密码：<Input.Password size="small" style={{height:30 , width:300}} 
            onChange={this.passwordChange} value={this.state.password} placeholder="input password"/>
          </div>
          <div>
            重复密码：<Input.Password size="small" style={{height:30 , width:300}} 
            onChange={this.passwordRepeatChange} value={this.state.passwordRepeat}/>
          </div>
        </Modal>
        {/* <Divider type="vertical" />
        {
          this.state.auth==0?
          <Popconfirm title="确定修改?" onConfirm={() => this.changeUserAuth(1)}>
              <a  href="javascript:;">设为正式用户</a>
          </Popconfirm>:
          <Popconfirm title="确定修改?" onConfirm={() => this.changeUserAuth(0)}>
              <a className="font-red" href="javascript:;">设为非正式用户</a>
          </Popconfirm>
        }
        <Divider type="vertical" />
        {
          this.state.auth!=4?
          <Popconfirm title="确定修改?" onConfirm={() => this.changeUserAuth(4)}>
              <a  href="javascript:;">设为管理员</a>
          </Popconfirm>:
          <Popconfirm title="确定修改?" onConfirm={() => this.changeUserAuth(1)}>
              <a className="font-red" href="javascript:;">设为正式用户</a>
          </Popconfirm>
        } */}
        <Divider type="vertical" />
        <Popconfirm title="确定删除?" onConfirm={() => this.deleteClass()}>
            <a  href="javascript:;">删除</a>
        </Popconfirm>
      </span>
    )
  }
}


class UpdateAtuh extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
    this.changeUserAuth = this.changeUserAuth.bind(this);
  }
  changeUserAuth(value) {
    console.log(`selected ${this.props.classAll.userId} ${value}`);
    fetch(ChangeUserAuth, {
      method: 'POST',
      headers : {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'userId='+this.props.classAll.userId+'&auth='+value
    }).then(res => res.json()).then(
      data => {
        if (data.code==0) {
          message.success('修改成功');
          emitter.emit('changeFirstText', '修改')
        } else {
          message.error(data.msg);
        }
      }
    )
  }
  render() {
    return (
      <span>
        <Select defaultValue={this.props.classAll.auth==4?<p>管理员</p>:this.props.classAll.auth==1?<p>正式用户</p>:<
          p>非正式用户</p>} style={{ width: 120 }} 
          onChange={this.changeUserAuth}>
        <Option value="0">非正式用户</Option>
        <Option value="1">正式用户</Option>
        <Option value="4">管理员</Option>
        </Select>
      </span>
    )
  }
}

class ShowTable extends React.Component{
  constructor(props) {
    super(props);
    this.columns = [{
      title: '手机号',
      dataIndex: 'mobile',
      key: 'mobile',
    },
    {
      title:'权限等级',
      key:'auth',
      render:(classAll)=> (
        <span>
          <UpdateAtuh classAll={classAll}/>
        </span>
      ),
    },
    {
      title: '用户名',
      dataIndex: 'username',
      key: 'username',
    },
    {
      title: '真实姓名',
      dataIndex: 'realname',
      key: 'realname',
    },
    {
      title: '学号',
      dataIndex: 'studentId',
      key: 'studentId',
    },  
    {
      title: '年级',
      dataIndex: 'grade',
      key: 'grade',
    },
    {
      title: '班级',
      dataIndex: 'classNum',
      key: 'classNum',
    },
    {
    title: '操作',
      key: 'action',
      render: (classAll) => (
        <span>
          <UpdateUser classAll={classAll}/>
        </span>
      ),
    }
  ];
  console.log(this.props.classAll);
  }
  tmp = (key) => {
    console.log("------"+key);
    emitter2.emit('changeShow', key);

  }
  passUser = (key) => {
    fetch(PassUser,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'userId='+key

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
  notPassUser = (key) => {
    fetch(NotPassUser,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'userId='+key

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
  beAdmin = (key) => {
    fetch(BeAdmin,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'userId='+key

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
  bePlayer = (key) => {
    fetch(BePlayer,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
           body: 'userId='+key

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
  

  render() {
    return(
    <div>
      <Table columns={this.columns} dataSource={this.props.classAll} pagination={false} />
      
    </div>
    
    );
  }
}



class ManageUser extends React.Component{
  constructor(props) {
    super(props);
    this.state={
      nowPage: 1,
      totalPage: 1,
      pageSize: 10,
      userAll: '',
      name: '',
    }
    this.announceTitleChange = this.announceTitleChange.bind(this);
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
    fetch(SelectUser, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'name='+this.state.name+'&pageNum='+this.state.nowPage+'&pageSize='+this.state.pageSize
    }).then( res=> res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({nowPage: data.resultBean.currentPage});
          this.setState({totalPage: data.resultBean.totalPage});
          this.setState({userAll: data.resultBean.items});
        } else {
          this.setState({nowPage: 1});
          this.setState({totalPage: 1});
          this.setState({userAll: ''});
        }
      }
    )
  }
  announceTitleChange(e) {
    this.setState({name: e.target.value});
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
          <h3>用户</h3>
        </div>
        <div className="searchF">
         <div className="example-input">
          <Input size="small" onChange={this.announceTitleChange} placeholder="用户名" style={{height:30 , width:150}}/>
          &nbsp;&nbsp;<Button type="primary" shape="circle" icon="search" onClick={this.buttonClick}/>
          </div>
        </div>
        <div className="search"> 
         <ShowTable classAll={this.state.userAll}/>
        </div>
        <div className="searchPage">
        <Pagination size="small" simple onChange={this.pageChange} total={this.state.totalPage*this.state.pageSize} 
        pageSize={this.state.pageSize} defaultCurrent={this.state.nowPage} showQuickJumper />
      </div>
      </div>
    );
  }
}
class ShowUser extends React.Component{
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
      sh = <ManageUser />
    } else {
      console.log('id:'+this.state.id)
      sh = <UserDetail userId={this.state.id}/>
    }
    return(
      <div>
      {sh}
      </div>
    );
  }
}
export default ShowUser;