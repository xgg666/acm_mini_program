import React from 'react';
import { Menu, Icon, Button, Input, Checkbox, Row, Col, Pagination,  Table, Divider, Tag,Alert  } from 'antd';

import AddNews from '../news/addNews';
import Classification from '../classification';
import Announcement from '../announce/announcement';
import ShowAnnounce from '../announce/manageAnnouncement';
import ShowNews from '../news/manageNews';
import BackHome from '../backIndex';
import UserDetail from '../userDetail';
import ManageUser from '../manageUser';
import AddCompetition from '../competition/addCompetition';
import ShowCompetition from '../competition/manageCompetition';
import PersonCompetition from '../competition/personCompetition';
import UpdateCompetition from '../competition/updateCompetition';
import ShowDayDuty from '../dayduty/manageDayduty';
import ShowImpression from "../impression/manageImpression"
import DoughnutChart from "../backIndex";


const routes = [
  {
    path: "/",
    exact: true,
    main: () => <BackHome />
  }, {
    path: "/index",
    exact: true,
    main: () => <DoughnutChart />
  }, {
    path: "/addNews",
    main: () => <AddNews />
  },
  {
    path: "/manageNews",
    main: () => <ShowNews />
  },
  {
    path: "/classify",
    main: () => <Classification />
  },
  {
    path: "/announcement",
    main: () => <Announcement />
  },
  {
    path: "/manageAnnounce",
    main: () => <ShowAnnounce />
  },
  {
    path: "/manageUser",
    main: () => <ManageUser />
  },
  {
    path: "/competition",
    main: () => <AddCompetition />

  },
  {
    path: "/manageCompetition",
    main: () => <ShowCompetition />
  },
  {
    path: "/detailCompetition/:id",
    main:  (props) => <UpdateCompetition {...props}/>
  },
  {
    path: "/personCompetition/:id",
    main:  (props) => <PersonCompetition {...props}/>
  },
  {
    path: "/manageDayDuty",
    main:  (props) => <ShowDayDuty />
  },
  {
    path: "/userDetail/:id",
    main:  (props) => <UserDetail {...props}/>
  },
  {
    path: "/manageImpression",
    main: (props) => <ShowImpression />
  }
];
export default routes;