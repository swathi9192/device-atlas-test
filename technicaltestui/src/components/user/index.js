import React from 'react'
import {connect} from 'react-redux'
import {Link} from 'react-router-dom'
import { getUser } from '../../redux/selectors/usersSelector'
import {loadUser} from '../../redux/actions/index'
import UserList from './UserList'
import "./User.scss"

class User extends React.Component{

    componentDidMount(){
        
        this.props.loadUser(this.props.match.params.id);
        
    }

    componentWillReceiveProps(nextProps){
        if(nextProps.match.params.id !== this.props.match.params.id) {
            this.props.loadUser(nextProps.match.params.id);
        }
    }
    render(){
        if(!this.props.user)
        return null;
        else
        return(<section className="section postComponent">

        <div className="columns is-flex is-flex-direction-column is-align-items-center">
        
          <div className="column is-6 ">
          <Link to="/"><span className="icon">
    <i className="fas fa-arrow-left"></i>
  </span>Back to home</Link>
          <article className="media user-content">
    <div className="media-left">
      <figure className="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image"/>
      </figure>
      </div>
      <div className="media-content">
      <h1 className="title">{this.props.user.name}</h1>
            <h4 className="subtitle">Lives in {this.props.user.city}</h4>
      </div>
      </article>
            <div className="friends section">
            <h2 className="subtitle is-4"><strong>Friends</strong></h2>
            {this.props.user.friends &&
           
            <UserList users={this.props.user.friends} from="singleUser"></UserList>
            }
            </div>
            <div className="suggestedFriends section">
<h2 className="subtitle is-4"><strong>Suggested Friends</strong></h2>
{this.props.user.suggestedFriends &&
           
           <UserList users={this.props.user.suggestedFriends} from="singleUser"></UserList>
           }
</div>

            

            
          </div>
        </div>
      </section>)
    }
}

const mapStateToProps = (state,ownProps) =>{
    return {
        user : getUser(state,ownProps.match.params.id)
    }
}
export default connect(mapStateToProps,{loadUser})(User)