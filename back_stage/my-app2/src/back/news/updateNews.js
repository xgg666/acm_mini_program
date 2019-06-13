import React from 'react'

import E from 'wangeditor'

import { Menu, Icon, Button, Input, Checkbox, Row, Col } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import '../static/my/css/news.css';
import '../static/my/css/classfication.css';
import {AddNewsMain} from '../../config/router.js';
import {UpdateNewsMain} from '../../config/router.js';
import {NewsDetail} from '../../config/router.js';
require('../../static/css/style.css');
require('../../static/css/bootstrap.min.css');
require('../../static/my/css/login.css');

function onChange(checkedValues) {
  console.log('checked = ', checkedValues);
}

function getString(s) {
  s=s.replace(/\+/g, "%2B");
  s=s.replace(/&/g, "%26");

  return s;
}

class UpdateNews extends React.Component {
  constructor(props, context) {
      super(props, context);
      this.state = {
        newsId: -1,
        isPublic: 0,
        editorContent: '',
        newsTitle: '',
        classifies: '',
        editor:'',
        classAll:[],
      }
      this.titleChange = this.titleChange.bind(this);
      this.classifiesChange = this.classifiesChange.bind(this);
      this.publish = this.publish.bind(this);
      this.draft = this.draft.bind(this);
      this.updateNews = this.updateNews.bind(this);
  }
  componentWillMount(){
    this.setState({newsId: this.props.newsId}, ()=>this.getData());
  }
  getData() {
    console.log('token'+cookie.load('token'));
    fetch(NewsDetail, {
      method: 'POST',
      headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'newsId='+this.props.newsId
    }).then( res => res.json()).then(
      data => {
        //console.log('token'+cookie.load('token'));
        //window.alert(data);
        //window.alert(data.code);
        if (data.code==0) {
          this.setState({newsTitle: data.resultBean.newsTitle});
          this.setState({classAll: data.resultBean.classifications});
          this.setState({editorContent: this.state.editor.txt.html(data.resultBean.newsBody)});
          console.log('xxx'+this.state.classifications);

        } else {
       //   console.log('未登录');
                 // this.props.history.push('/login');
          window.alert('xx');
        }
      }
  
    )
  }
  titleChange(e) {
    console.log(e.target.value);
      this.setState({newsTitle: e.target.value});
      console.log(this.state.newsTitle);
  }
  classifiesChange(checkedValues) {
      this.setState({classifies: checkedValues});
      console.log(this.state.classifies);
  }
  publish() {
    console.log('----'+this.state.newsId);
    console.log('----'+this.state.editorContent);
    if (this.state.newsId==-1) {
      this.setState({isPublic: 1}, ()=>this.updateNews())
    } else {
      this.setState({isPublic: 1}, ()=>this.updateNews())
    //console.log(this.state.newsId);

    }
  }
  draft() {
    if (this.state.newsId==-1) {
      this.setState({isPublic: 0}, ()=>this.updateNews())
    } else {
      this.setState({isPublic: 0}, ()=>this.updateNews())

    }
  }
  
  updateNews() {
    if (this.state.newsTitle.length==0) {
      alert('新闻标题不为空');
      return;
    }
    if (encodeURI(this.state.editorContent).length==0) {
      alert('新闻内容不为空');
      return;
    }
    fetch(UpdateNewsMain,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'newsId='+this.state.newsId+'&newsTitle='+this.state.newsTitle+'&newsBody='+encodeURI(getString(this.state.editorContent))+'&isPublic='+this.state.isPublic

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  alert('修改成功');
                  this.setState({newsId: data.resultBean});
                   console.log(this.state.newsId);
                }
                else {
                  window.alert(data.msg);
                  this.setState({newsId: -1});
                }
            }
        )
  }
  render() {
    return (
      <div>
      <div className="col-md-9">
        <div className="title">
          <h2>撰写新闻</h2>
        </div>
        <div className="inputTitle">
          <Input size="small" value={this.state.newsTitle} placeholder="input with clear icon" style={{height:30}} onChange={this.titleChange}/>
        </div>
        <br/>
        <div className="inputTitle">
        <div ref="editorElem" className="toolbar">
        <p>{this.state.newsBody}</p>
        </div>  
        </div>

      </div>

      <div className="col-md-3">
      <br/><br/>
        <div className="push">
          <h3>发布</h3>
          <hr/>
          <Button size="small">保存为草稿</Button>
          <br/><br/>
          <Button type="primary" onClick={this.publish}>发布</Button>
        </div>
        <div className="inputCatalog">
           <h3>分类</h3>
            <CheckClass classAll={this.state.classAll}/>
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
     // alert(this.state.editorContent);
    }
    editor.create()
  }
  clickHandle() {
      alert(this.state.editorContent)
  }
}
class CheckClass extends React.Component {
  render() {
    return(
      <div>
        <Checkbox.Group style={{ width: '100%' }} onChange={this.checkOnChange} disabled={true} >
          <Row>
          {
            this.props.classAll.map(function (item) {
              return (
                <Col span={24}><Checkbox checked={true} value={item.classId} >{item.className}</Checkbox></Col>
              )
            })
          }
          </Row>
        </Checkbox.Group>
      </div>
    )
  }
}
export default UpdateNews;