import React from 'react'
import { HashRouter as Router, Switch, Route } from 'react-router-dom'
import Home from "./home/index";
import User from "./user/index";
import './App.scss'
class App extends React.Component{
    render(){
        return (<Router>
            <div className="container-fluid ">
              <div className="mainContainer">
                
                <Switch>
                  <Route
                    path="/"
                    exact
                    component={Home}
                  ></Route>
                  
                  <Route
                    path="/user/:id"
                    component={User}
                  ></Route>
                  <Route component={() => <div>404 Not found </div>} />
                </Switch>
              </div>
            </div>
          </Router>)
    }
}

export default App