import React from 'react';
import { BrowserRouter as Router,Route} from 'react-router-dom';
import { Switch} from 'react-router-dom';
import Login from './Login';
import Register from './register';
import Aside from './back/backHome';
import 'antd-mobile/dist/antd-mobile.css';
class App extends React.Component {

	render() {
		return (
			<Router >
				<div>
                    <Route path="/login" component={Login} />
                    <Route path="/Aside" component={Aside} />
										
			</div>
            </Router>
		)
	}
}

export default App;