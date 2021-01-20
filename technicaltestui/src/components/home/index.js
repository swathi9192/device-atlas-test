import React from 'react'
import { getUsers } from '../../redux/selectors/usersSelector'
import {loadUsers} from '../../redux/actions/'
import { connect } from 'react-redux';
import UserList from '../user/UserList'

class Home extends React.Component{

    componentDidMount(){
        this.props.loadUsers();
    }
    render(){
        return(<section className="section">

        <div className="columns is-flex is-flex-direction-column is-align-items-center">
            <h2 className="title is-4">List of Users from Device Atlas </h2>
         <UserList users={this.props.users} />
        </div>
      </section>)
    }
}
const mapStateToProps = (state) =>{
    return {
        users: getUsers(state)
    }
}
export default connect(mapStateToProps,{loadUsers})(Home)