
import React from 'react'

import E from 'wangeditor'

import { Timeline, Icon, Card, Tag, Divider, Row, Col, message, Button, Badge, Tabs } from 'antd';
import cookie from 'react-cookies';
import 'antd/lib/date-picker/style/css'; 
import 'antd/dist/antd.css';
import './static/my/css/news.css';
import './static/my/css/classfication.css';
import './static/my/css/info.css';
import {GetIndexInfo} from '../config/router.js';
import {GetLecComInfo} from '../config/router.js';
import {GetNewAnnInfo} from '../config/router.js';
import ReactHighcharts from 'react-highcharts';
import Highcharts from 'highcharts';
import { DEFAULT_ECDH_CURVE } from 'tls';
require('../static/css/style.css');
require('../static/css/bootstrap.min.css');
require('../static/my/css/login.css');
require('./static/my/css/home.css');

const { TabPane } = Tabs;


class DoughnutChart extends React.Component{

    constructor(props) {
      super(props);
        this.state = {
          news: [],
          announcement: [],
          competition: [],
        }
      
    }
    componentWillMount(){
      this.getData();
    }
    getData() {
      fetch(GetNewAnnInfo, {
        method: 'POST',
        headers: {
          'Authorization': cookie.load('token'),
          'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        }
      }).then( res => res.json()).then(
        data => {
          var tmp = this.state.options1;
          //alert(data.code);Timeline
          if (data.code==0) {
            this.setState({news: data.resultBean.news});
            this.setState({announcement: data.resultBean.announ});
            this.setState({competition: data.resultBean.competition});
            //this.setState({series:this.series[0].data.add(data.resultBean)});
           // this.setState({series[0].data: data.resultBean})
           console.log(data.resultBean);
          //  tmp.series[0].data = data.resultBean;
          //  this.setState({options1: tmp}, ()=>{console.log(this.state.options1)});
           //return data.resultBean;
          } else {
            message.error(data.msg);
          }
        }
      )
    }
  render() {
    return (
      <div>
              
        <div style={{margin:'30px'}}>
          <Row gutter={16} >
            <Col span={8} >
            <div style={{margin:'30px', backgroundColor: '#ffffff'}}>
            <h2 className='center'> 近期新闻 </h2>
            <Timeline className='timeline'>
            {
              this.state.news.map(item => {
                return(
                  <div>
                  <Timeline.Item>
                    {item.newsTitle}&nbsp;&nbsp;&nbsp;{item.updateDate}
                  </Timeline.Item>
                  </div>
                )
              })
            }
            </Timeline>
            </div>
            </Col>
            <Col span={8} >

            <div style={{margin:'30px', backgroundColor: '#ffffff'}}>
              <h2 className='center'> 近期公告 </h2>
              <Timeline className='timeline'>
              {
                this.state.announcement.map(item => {
                  return(
                    <div>
                    <Timeline.Item>
                      {item.announceTitle}&nbsp;&nbsp;&nbsp;{item.announceUpdateTime}
                    </Timeline.Item>
                    </div>
                  )
                })
              }
              </Timeline>
            </div>
            </Col>
            <Col span={8} >
              <div style={{margin:'30px', backgroundColor: '#ffffff'}}>
                <h2 className='center'> 近期校赛 </h2>
                <Timeline className='timeline'>
                {
                  this.state.competition.map(item => {
                    return(
                      <div>
                      <Timeline.Item>
                        {item.competitionTitle}&nbsp;&nbsp;&nbsp;{item.createDate}
                      </Timeline.Item>
                      </div>
                    )
                  })
                }
                </Timeline>
              </div>
            </Col>
          </Row>


        </div>
      </div>
    );
  }
}

class AllNum extends React.Component{

  constructor(props) {
    super(props);
    this.state = {
      allFriendNum: '',
      nowDuty: '',
      allInvitationNum: '',
      allUserNum: '',
      impression: [],
    }

  }
  componentWillMount(){
    this.getData();
  }
  getData() {
    fetch(GetIndexInfo, {
      method: 'POST',
      headers: {
        'Authorization': cookie.load('token'),
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
      }
    }).then( res => res.json()).then(
      data => {
        if (data.code==0) {
          this.setState({allFriendNum: data.resultBean.allFriendNum});
          this.setState({nowDuty: data.resultBean.nowDuty});
          this.setState({allInvitationNum: data.resultBean.allInvitationNum});
          this.setState({allUserNum: data.resultBean.allUserNum});
          this.setState({impression: data.resultBean.impression});
        } else {
          message.error(data.msg);
        }
      }
  
    )
  }
  render() {
    const content = (
      <div>
        <p>Content</p>
        <p>Content</p>
      </div>
    );
    return(
      <div style={{margin:'20px', padding:'20px'}}>
        <Row gutter={16}>
          <Col span={6} >
          <Card title="用户人数" style={{  }}>
              <span><Icon type="user" style={{ fontSize: '20px' }}/>&nbsp;&nbsp;</span>
              <p style={{fontSize:'25px'}}><strong>{this.state.allUserNum}</strong></p>
              <p style={{fontSize:'25px'}}><strong></strong></p>
          </Card>
          </Col>
          <Col span={10}>
          <Card title="印象最赞榜" style={{  }}>

            <Tabs defaultActiveKey="1">
            {
              this.state.impression.map(item => {
                return(
                  <TabPane tab={item.username} key={item.userId}>
                  {
                        item.impressionList.map(im => {
                          return(
                              <Button color='red'> 
                                {im.impressionTitle} <Icon type="bulb" />
                                <Badge count={im.agreeNum} style={{ backgroundColor: '#52c41a' }}/>
                              </Button>
                          )
                        })
                  }
                  </TabPane>
                )
              })
            }
            </Tabs>
          </Card>
          </Col>          
          <Col span={6}>
          <Card title="今日值日人" style={{ }}>
              <span><Icon type="contacts" style={{ fontSize: '20px' }}/>&nbsp;&nbsp;</span>
              <p style={{fontSize:'25px'}}><strong>{this.state.nowDuty}</strong></p>
              <p style={{fontSize:'25px'}}><strong></strong></p>
          </Card>
          </Col>


        </Row>
      </div>
    );
  }
}

class BackHome extends React.Component{

  render() {
    return(
      <div>
        <AllNum />
        <Divider />
        <DoughnutChart/>
      </div>
    );
  }

}

export default BackHome;