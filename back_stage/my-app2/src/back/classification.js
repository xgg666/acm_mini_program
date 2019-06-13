import React from 'react';

import E from 'wangeditor';

import { Menu, Icon, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert ,Popconfirm } from 'antd';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import './static/my/css/classfication.css';
import cookie from 'react-cookies';
import {data} from './config/classifiConf';
import {AddNew} from '../config/router.js';
import {SelectClass} from '../config/router.js';
import {EventEmitter2} from 'eventemitter2'
import {DeleteClass} from '../config/router.js';
require('../static/css/bootstrap.min.css');


var emitter = new EventEmitter2()

const Search = Input.Search;


class ShowTable extends React.Component{
	constructor(props) {
		super(props);
		this.columns = [{
		  title: '名称',
		  dataIndex: 'className',
		  key: 'className',
		  render: text => <a href="javascript:;">{text}</a>,
		}, {
		  title: '创建时间',
		  dataIndex: 'createTime',
		  key: 'createTime',
		},  {
		  title: '操作',
		  key: 'action',
		  render: (text, record) => (
		    <Popconfirm title="确定删除?" onConfirm={() => this.handleDelete(record.classId)}>
		      <a href="javascript:;">Delete</a>
		    </Popconfirm>
		          
		   ),
		}];
	}
	handleDelete = (key) => {
   		fetch(DeleteClass,{   //Fetch方法
            method: 'POST',
            headers: {
            	'Authorization': cookie.load('token'),
            	'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
			body: 'classId='+key

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                	emitter.emit('changeFirstText', 'Second'); //触发事件
                }
                else {
   					window.alert(data.code.msg);
                }
            }
        )
	}

	render() {
		return(
			<Table columns={this.columns} dataSource={this.props.classAll} pagination={false} />
		);
	}
}
class Reason extends React.Component{
	render() {
		return(
			<Alert
		      message={this.props.reason}
		      type={this.props.type}
		      closable
		    />
		);
	}
}
class AddClassify extends React.Component{
	constructor(props) {
		super(props);
		this.state = {
			className: '',
			isError: false,
			reason: 'xx',
			isSuccess: false,
		}
		this.classNameChange = this.classNameChange.bind(this);
		this.addClass = this.addClass.bind(this);
	}

 	
	classNameChange(e) {
		this.setState({className: e.target.value});
		this.setState({isError: false});
        this.setState({isSuccess: false});
	}
	addClass(e) {
		e.preventDefault();
	 	this.getDate();
	}
	getDate() {
		//console.log(this.state.className);
		if (this.state.className.length==0) {
			this.setState({reason: '目录名称不能为空'});
			this.setState({isError: true});
			return;
		}
		fetch(AddNew,{   //Fetch方法
            method: 'POST',
            headers: {
            	'Authorization': cookie.load('token'),
            	'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
			body: 'name='+this.state.className

        }).then(res => res.json()).then(
            data => {
				//window.alert('code'+data.code);
                if(data.code==0) {
                	//window.alert('添加成功');
					this.setState({isError: false});
                	this.setState({isSuccess: true});
                	emitter.emit('changeFirstText', 'Second');
                }
                else {
                	this.setState({isError: true});
                	this.setState({isSuccess: false});
                	this.setState({reason: data.msg});
                	return false;
                }
            }
        )
	}
	render() {
		
		let errorShow;
		if (this.state.isError==true) {
			errorShow = <Reason reason={this.state.reason} type="error"/>
		}
		if (this.state.isSuccess==true) {
			errorShow = <Reason reason="添加成功" type="success"/>

		}
		return(
			<div>
				<div className="title">
					<h3>分类目录</h3>
				</div>
				<div className="title">
					<h4>添加新分类目录</h4>
					{errorShow}
					<div className="example-input">
						<Input size="small" placeholder="目录名"  style={{height:30}} onChange={this.classNameChange}/>
					</div>
					<div className="addButton">
						<Button type="primary" onClick={this.addClass}>添加</Button>
					</div>
					
				</div>
				
			</div>
		);
	}
}
class HaveClassify extends React.Component{
	constructor(props) {
		super(props);
		this.state={
			nowPage: 1,
			totalPage: 2,
			pageSize: 10,
			classAll: '',
			className: '',
		}
		this.classNameChange = this.classNameChange.bind(this);
		this.buttonClick = this.buttonClick.bind(this);
		emitter.on('changeFirstText', this.changeText.bind(this))
	}

	changeText( msg ){
        this.getClass();
    }
	classNameChange(e) {
		console.log(e.target.value);
		this.setState({className: e.target.value});
	}
	buttonClick(e) {
		e.preventDefault();
	 	this.getClass();
	}
	

	componentWillMount() {
		this.getClass();
	}
	getClass() {
		fetch(SelectClass, {
			method: 'POST',
			headers: {
				'Authorization': cookie.load('token'),
            	'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
			},
			body: 'className='+this.state.className+'&pageNum='+this.state.nowPage
		}).then( res=> res.json()).then(
			data => {
				//console.log('token'+cookie.load('token'));
				//window.alert(data);
				//window.alert(data.code);

				if (data.code==0) {
					this.setState({nowPage: data.resultBean.currentPage});
					this.setState({totalPage: data.resultBean.totalItems/data.resultBean.pageSize});
					this.setState({classAll: data.resultBean.items});
				} else {
					this.setState({nowPage: 1});
					this.setState({totalPage: 1});
					this.setState({classAll: ''});
				}
			}
		)
	}
	pageChange = (page) => {
		console.log(page);
	    this.setState({ nowPage: page }, () => this.getClass());
	 	
	}
	render() {
		return(
		<div className="search">
			<div className="search">
				<div className="example-input">
					<Input size="small" onChange={this.classNameChange} placeholder="目录名" style={{height:30 , width:150}}/>
					&nbsp;&nbsp;<Button type="primary" shape="circle" icon="search" onClick={this.buttonClick}/>
				</div>
			</div>
			<div>
				<ShowTable classAll={this.state.classAll}/>
			</div>
			<div className="searchPage">
				<Pagination size="small" simple onChange={this.pageChange} total={this.state.totalPage*this.state.pageSize} defaultCurrent={this.state.nowPage} showQuickJumper />
			</div>
		</div>
		);
	}
}
class AddNews extends React.Component {
 
  render() {
    return (
      <div>
		<div className="col-md-4">
			<AddClassify />
		</div>
		<div className="col-md-8">
			<HaveClassify />
		</div>
      </div>
    );
  }
}

export default AddNews;