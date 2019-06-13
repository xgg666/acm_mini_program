import React from 'react';

import E from 'wangeditor'

import { Menu, Icon, Button, Input, Checkbox, Row, Col } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/news.css';
import '../static/my/css/classfication.css';
import {AddAnnounce} from '../../config/router.js';
import {UpdateAnnounce} from '../../config/router.js';
import {AnnounceDetail} from '../../config/router.js';

function getString(s) {
  s=s.replace(/\+/g, "%2B");
  s=s.replace(/&/g, "%26");

  return s;
}

class UpdateAnnouncement extends React.Component{
	constructor(props) {
      super(props);
      this.state = {
        announceId: 0,
        editorContent: '',
        announceTitle: '',
        announceBody:'',
        isPublic: 0,
        editor:'',
      }
      this.titleChange = this.titleChange.bind(this);
      this.publish = this.publish.bind(this);
  }
  componentWillMount(){
    this.setState({announceId: this.props.announceId}, ()=>this.getData());
  }
  getData() {
    console.log('token'+cookie.load('token'));
    fetch(AnnounceDetail, {
      method: 'POST',
      headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'announceId='+this.props.announceId
    }).then( res => res.json()).then(
      data => {
        //console.log('token'+cookie.load('token'));
        //window.alert(data);
        //window.alert(data.code);
        if (data.code==0) {
          this.setState({announceTitle: data.resultBean.announceTitle});
          this.setState({announceBody: this.state.editor.txt.html(data.resultBean.announceBody)});
          console.log('xxx'+this.state.announceTitle);

        } else {
       //   console.log('未登录');
                 // this.props.history.push('/login');
          window.alert('xx');
        }
      }
  
    )
  }
  titleChange(e) {
      this.setState({announceTitle: e.target.value});
      console.log(this.state.announceTitle);
  }
  publish() {
    console.log(this.state.announceId);
    if (this.state.announceId==-1) {
      this.setState({isPublic: 1}, ()=>this.saveAnnounce())
    } else {
      this.setState({isPublic: 1}, ()=>this.updateAnnounce())

    }
  }
  draft() {
    if (this.state.announceId==0) {
      this.setState({isPublic: 0}, ()=>this.saveAnnounce())
    } else {
      this.setState({isPublic: 0}, ()=>this.updateAnnounce())

    }
  }
  saveAnnounce() {
    if (this.state.announceTitle.length==0) {
      alert('公告标题不为空');
      return;
    }
    if (encodeURI(this.state.announceBody).length==0) {
      alert('公告内容不为空');
      return;
    }
    fetch(AddAnnounce,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'announceTitle='+this.state.announceTitle+'&announceBody='+encodeURI(getString(this.state.editorContent))+'&isPublic='+this.state.isPublic

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  alert('添加成功');
                  this.setState({announceId: data.resultBean});
                }
                else {
                  window.alert(data.msg);
                  this.setState({announceId: -1});
                }
            }
        )
  }
  updateAnnounce() {
    if (this.state.announceTitle.length==0) {
      alert('公告标题不为空');
      return;
    }
    if (encodeURI(this.state.announceBody).length==0) {
      alert('公告内容不为空');
      return;
    }
    console.log(this.state.announceId);
    fetch(UpdateAnnounce,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'announceId='+this.state.announceId+'&announceTitle='+this.state.announceTitle+'&announceBody='+encodeURI(getString(this.state.editorContent))+'&isPublic='+this.state.isPublic

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  alert('修改成功');
                  //this.props.history.push('/home/index');
                }
                else {
                  window.alert(data.msg);
                  this.setState({announceId: -1});
                }
            }
        )
  }
  render() {
    return (
      <div>
      <div className="col-md-10">
        <div className="title">
          <h2>修改公告</h2>
        </div>
        <div className="inputTitle">
          <Input size="small" value={this.state.announceTitle} placeholder="input with clear icon" style={{height:30}} onChange={this.titleChange}/>
        </div>
        <br/>
        <div className="inputTitle">
          <div ref="editorElem" className="toolbar" >
          <p>{this.state.announceBody}</p>
          </div>  

        </div>

      </div>
      <div className="col-md-2">
      <br/><br/>
        <div className="push">
          <h3>发布</h3>
          <hr/>
          <Button size="small" onClick={this.draft}>保存为草稿</Button>
          <br/><br/>
          <Button type="primary" onClick={this.publish}>发布</Button>
        </div>
        
      </div>
      </div>
     );
}
componentDidMount() {
    const elem = this.refs.editorElem
    const editor = new E(elem)
    this.setState({editor: editor});
	 editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
	 editor.customConfig.uploadFileName = 'myFileName';
	editor.customConfig.uploadImgServer = 'http://localhost:9999/uploadImg';
	editor.customConfig.uploadImgHooks = { 
		customInsert: function (insertImg, result, editor) { 
		var url =result.data; insertImg(url); 
		} 
	};

    // 使用 onchange 函数监听内容的变化，并实时更新到 state 中
    editor.customConfig.onchange = html => {
      this.setState({
        editorContent: getString(html)
      })
    }
    editor.create()
  }
 
}



function onChange(checkedValues) {
  console.log('checked = ', checkedValues);
}


export default UpdateAnnouncement;