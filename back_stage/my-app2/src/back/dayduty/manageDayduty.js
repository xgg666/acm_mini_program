import React from 'react';

import { Menu, Icon, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm, message, Modal } from 'antd';
import cookie from 'react-cookies';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/classfication.css';
import {SelectDayDuty} from '../../config/router.js';
import {UpdateDayDutyUrl} from '../../config/router.js';
import {UpdateFriendUrl} from '../../config/router.js';
import {DetailDayDuty} from '../../config/router.js';
import {AddFriendUrl} from '../../config/router.js';
import {DoneCompetitionUrl} from '../../config/router.js';
import {EventEmitter2} from 'eventemitter2'
var emitter = new EventEmitter2()
var emitter2 = new EventEmitter2()

const id = -1;

class UpdateDayDuty extends React.Component {
  state = { visible: false }

  constructor(props) {
    super(props);
    this.state = {
      dayName:'',
      dutyUserNames:'',
      dayDutyId:''
    }
    this.getClass = this.getClass.bind(this);
    this.urlbodyChange = this.urlbodyChange.bind(this);
    this.updateClass = this.updateClass.bind(this);
  }

  showModal = () => {
    this.setState({
      visible: true,
    });
  }

  handleOk = (e) => {
    console.log(e);
    this.setState({
      visible: false,
    });
  }

  handleCancel = (e) => {
    console.log(e);
    this.setState({
      visible: false,
    });
  }

  componentWillMount(){
    this.getClass();
  }

  getClass() {
    fetch(DetailDayDuty, {
      method: 'POST',
      headers:{
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body:'dayDutyId='+this.props.daydutyId
    }).then(res => res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({dayName: data.resultBean.dayName})
          this.setState({dutyUserNames: data.resultBean.dutyUserNames})
          this.setState({dayDutyId: data.resultBean.dayDutyId})

        } else {
          message.error(data.msg);
        }
      }
    )
  }
  updateClass() {
    fetch(UpdateDayDutyUrl, {
      method: 'POST',
      headers : {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body:'dayDutyId='+this.state.dayDutyId+'&dutyUserNames='+this.state.dutyUserNames
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

  urlbodyChange = (e) => {
    this.setState({dutyUserNames: e.target.value});
  }
  render(){
    console.log(this.state.friendurlId)
    return (
      <span>
        <a href="javascript:;" onClick={this.showModal}>修改</a>
         <Modal
          title="修改"
          visible={this.state.visible}
          onOk={this.updateClass}
          onCancel={this.handleCancel}
          okText="确认修改"
          cancelText="取消"
        >
          <div>
            值日时间：<Input size="small" style={{height:30 , width:300}} 
            value={this.state.dayName} disabled/>
          </div>
          <div>
            值&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;人：
            <Input size="small"  style={{height:30 , width:300}} 
            onChange={this.urlbodyChange} value={this.state.dutyUserNames}/>
          </div>
        </Modal>
      </span>
    )
  }
}
class ShowTable extends React.Component{
  constructor(props) {
    super(props);
    this.tmp = this.tmp.bind(this);
    this.columns = [{
      title: '值日',
      dataIndex: 'dayName',
      key: 'dayName',
      render: (text, record) => (
        <span>
        <a href="javascript:;">{record.dayName}</a>
          
           </span>
       ),
    }, {
      title: '值日人',
      dataIndex: 'dutyUserNames',
      key: 'dutyUserNames',
    }, {
      title: '创建时间',
      dataIndex: 'createDate',
      key: 'createDate',
    },  {
      title: '操作',
      key: 'action',
      render: (text, record) => (
        <span>
          <UpdateDayDuty daydutyId={record.dayDutyId}/>
          
        </span>
       ),
    }
    ];
  }
  
  tmp = (key) => {
    console.log("------"+key);
    emitter2.emit('changeShow', key);

  }
  
  

  render() {
    return(
    <div>
      <Table columns={this.columns} dataSource={this.props.all} pagination={false} />
      
    </div>
    
    );
  }
}

class AllDayDuty extends React.Component{

  constructor(props) {
    super(props);
    this.state={
      nowPage: 1,
      totalPage: 1,
      pageSize: 10,
      all: '',
    }
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
    fetch(SelectDayDuty, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: '&pageNum='+this.state.nowPage+'&pageSize='+this.state.pageSize
    }).then( res=> res.json()).then(
      data => {
        console.log("data" + data)
        if (data.code==0) {
          if(data.resultBean.currentPage>0) {
            this.setState({nowPage: data.resultBean.currentPage});
          }else {
            this.setState({nowPage: 1});
          }
          this.setState({totalPage: data.resultBean.totalItems/data.resultBean.pageSize});
          this.setState({all: data.resultBean});
        } else {
          this.setState({nowPage: 1});
          this.setState({totalPage: 1});
          this.setState({all: ''});
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
          <h3>值日</h3>
        </div>
        <div className="search"> 
         <ShowTable all={this.state.all}/>
        </div>
        
      </div>
    );
  }
}
class ShowDayDuty extends React.Component{
  render() {
    return(
      <div>
       <AllDayDuty />
      </div>
    );
  }
}
export default ShowDayDuty;