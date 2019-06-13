
import React from 'react'

import E from 'wangeditor'

import { Menu, DatePicker, Button, Input, Checkbox, Row, Col, message } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/news.css';
import '../static/my/css/classfication.css';
import {AddCompetitionUrl} from '../../config/router.js';
import {UpdateCompetitionUrl} from '../../config/router.js';
import {SelectClass} from '../../config/router.js';
require('../../static/css/style.css');
require('../../static/css/bootstrap.min.css');
require('../../static/my/css/login.css');

function getString(s) {
  s=s.replace(/\+/g, "%2B");
  s=s.replace(/&/g, "%26");

  return s;
}

class AddCompetition extends React.Component {
  state = { mode: 'date' };
  constructor(props, context) {
      super(props, context);
      this.state = {
        competitionId: -1,
        editorContent: '',
        title: '',
        editorContentText:'',
        beginTime: '',
        untilTime: '',
      }
      this.titleChange = this.titleChange.bind(this);
      this.publish = this.publish.bind(this);
      this.saveCompetition = this.saveCompetition.bind(this);
      this.updateCompetition = this.updateCompetition.bind(this);
      this.changeBeginTime = this.changeBeginTime.bind(this);
      this.changeUntilTime = this.changeUntilTime.bind(this);
  }
  titleChange(e) {
    console.log(e.target.value);
      this.setState({title: e.target.value});
      console.log(this.state.title);
  }
  publish() {
    console.log('----'+this.state.competitionId);
    console.log('----'+this.state.editorContent);
    if (this.state.competitionId==-1) {
     this.saveCompetition()
    } else {
      this.updateCompetition()
    //console.log(this.state.newsId);

    }
  }
  saveCompetition() {
    if (this.state.title.length==0) {
      alert('校赛标题不为空');
      return;
    }
    if (this.state.editorContentText.length==0) {
      alert('新闻内容不为空');
      return;
    }
    fetch(AddCompetitionUrl,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'competitionTitle='+this.state.title+'&competitionBody='+encodeURI(getString(this.state.editorContent))+'&competitionBeginTime='+this.state.beginTime
        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  message.success('添加成功');
                  this.setState({competitionId: data.resultBean});
                   console.log(this.state.newsId);
                }
                else {
                  message.error(data.msg);
                  this.setState({newsId: -1});
                }
            }
        )
  }
  updateCompetition() {
    if (this.state.title.length==0) {
      alert('新闻标题不为空');
      return;
    }
    if (this.state.editorContentText.length==0) {
      alert('新闻内容不为空');
      return;
    }
    fetch(UpdateCompetitionUrl,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'competitionId='+this.state.competitionId+'&competitionTitle='+this.state.title+'&competitionBody='+encodeURI(getString(this.state.editorContent))+'&competitionBeginTime='+this.state.beginTime

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  message.success('修改成功');
                  this.setState({newsId: data.resultBean});
                   console.log(this.state.newsId);
                }
                else {
                  message.error(data.msg);
                }
            }
        )
  }

  handleOpenChange = open => {
    if (open) {
      this.setState({ mode: 'date' });
    }
  };

  handlePanelChange = (value, mode) => {
    this.setState({ mode });
  };

  checkOk() {
  }

  changeBeginTime(data, dataString) {
    this.setState({beginTime: dataString});
  }

  changeUntilTime(data, dataString) {
    this.setState({untilTime: dataString});
    console.log(this.state.untilTime);
  }
  render() {
    return (
      <div>
      <div className="col-md-9">
        <div className="title">
          <h2 >添加校赛</h2>
        </div>
        <div className="inputTitle">
          <Input size="small" placeholder="校赛名称" style={{height:30}} onChange={this.titleChange}/>
        </div>
        <br/>
        <div className="inputTitle">
        <div ref="editorElem" className="toolbar">
        </div>  
        </div>

      </div>

      <div className="col-md-3">
      <br/><br/>
        <div className="push">
          <h3>发布</h3>
          <hr/>
          <Button type="primary" onClick={this.publish}>发布</Button>
        </div>
        
      <div>

        <span> 
        <div>
        <p style={{marginTop: 50}}>校赛开始时间:</p>
        <DatePicker
          format="YYYY-MM-DD HH:mm:ss"
          mode={this.state.mode}
          showTime
          placeholder="选择校赛开始时间"
          onOpenChange={this.handleOpenChange}
          onPanelChange={this.handlePanelChange}
          onChange={this.changeBeginTime}
          onOk={this.checkOk}
        />
        </div>
        </span>
      </div>
      </div>

      </div>
    );
  }
  componentDidMount() {
    const elem = this.refs.editorElem
    const editor = new E(elem)
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
      this.setState({editorContentText: editor.txt.text()})
    }
    editor.create()
  }
}

export default AddCompetition;