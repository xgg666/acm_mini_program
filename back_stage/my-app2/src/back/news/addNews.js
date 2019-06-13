
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
import {SelectClass} from '../../config/router.js';
require('../../static/css/style.css');
require('../../static/css/bootstrap.min.css');
require('../../static/my/css/login.css');

function getString(s) {
  s=s.replace(/\+/g, "%2B");
  s=s.replace(/&/g, "%26");

  return s;
}

class CheckClass extends React.Component {
  constructor(props) {
    super(props);
    this.state =  {
      classAll:[]
    }
    this.getClass = this.getClass.bind(this);
    this.checkOnChange = this.checkOnChange.bind(this);
  }
  componentWillMount(){
    this.getClass();
  }
  checkOnChange(checkedValues) {
   console.log('checked = ', checkedValues);
      this.props.classifiesChange(checkedValues);
  }
  getClass() {
    fetch(SelectClass, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      },
      body: 'pageSize='+100
    }).then( res=> res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({classAll: data.resultBean.items});
          console.log('---'+this.state.classAll);
        } else {
          this.setState({classAll: ''});
        }
      }
    )
  }
  render() {
    return(
      <div>
        <Checkbox.Group style={{ width: '100%' }} onChange={this.checkOnChange}>
          <Row>
          {
            this.state.classAll.map(function (item) {
              return (
                <Col span={24}><Checkbox value={item.classId}>{item.className}</Checkbox></Col>
              )
            })
          }
          </Row>
        </Checkbox.Group>
      </div>
    )
  }
}
class AddNewss extends React.Component {
  constructor(props, context) {
      super(props, context);
      this.state = {
        newsId: -1,
        isPublic: 0,
        editorContent: '',
        title: '',
        classifies: '',
      }
      this.titleChange = this.titleChange.bind(this);
      this.classifiesChange = this.classifiesChange.bind(this);
      this.publish = this.publish.bind(this);
      this.draft = this.draft.bind(this);
      this.saveNews = this.saveNews.bind(this);
      this.updateNews = this.updateNews.bind(this);
  }
  titleChange(e) {
    console.log(e.target.value);
      this.setState({title: e.target.value});
      console.log(this.state.title);
  }
  classifiesChange(checkedValues) {
      this.setState({classifies: checkedValues});
      console.log('---------father'+checkedValues);
      console.log('---------father'+this.state.classifies);
  }
  publish() {
    console.log('----'+this.state.newsId);
    console.log('----'+this.state.editorContent);
    if (this.state.newsId==-1) {
      this.setState({isPublic: 1}, ()=>this.saveNews())
    } else {
      this.setState({isPublic: 1}, ()=>this.updateNews())
    //console.log(this.state.newsId);

    }
  }
  draft() {
    if (this.state.newsId==-1) {
      this.setState({isPublic: 0}, ()=>this.saveNews())
    } else {
      this.setState({isPublic: 0}, ()=>this.updateNews())

    }
  }
  saveNews() {
    if (this.state.title.length==0) {
      alert('新闻标题不为空');
      return;
    }
    if (encodeURI(this.state.editorContent).length==0) {
      alert('新闻内容不为空');
      return;
    }
    fetch(AddNewsMain,{   //Fetch方法
            method: 'POST',
            headers: {
              'Authorization': cookie.load('token'),
              'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: 'newsTitle='+this.state.title+'&newsBody='+encodeURI(getString(this.state.editorContent))+'&isPublic='+this.state.isPublic+'&classType='+this.state.classifies

        }).then(res => res.json()).then(
            data => {
                if(data.code==0) {
                  alert('添加成功');
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
  updateNews() {
    if (this.state.title.length==0) {
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
            body: 'newsId='+this.state.newsId+'&newsTitle='+this.state.title+'&newsBody='+encodeURI(getString(this.state.editorContent))+'&isPublic='+this.state.isPublic+'&classType='+this.state.classifies

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
          <Input size="small" placeholder="新闻名称" style={{height:30}} onChange={this.titleChange}/>
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
          <Button size="small" onClick={this.draft}>保存为草稿</Button>
          <br/><br/>
          <Button type="primary" onClick={this.publish}>发布</Button>
        </div>
        <div className="inputCatalog">
           <h3>分类</h3>
            <CheckClass classifiesChange={this.classifiesChange}/>
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
  // 自定义菜单配置
editor.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'link',  // 插入链接
    'list',  // 列表
    'justify',  // 对齐方式
    'quote',  // 引用
    'emoticon',  // 表情
    'image',  // 插入图片
    //'table',  // 表格
    'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
];
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
      //alert(this.state.editorContent);
    }
    editor.create()
  }
  clickHandle() {
      alert(this.state.editorContent)
  }
}

export default AddNewss;