import { Link } from "react-router-dom";
import './User.scss'

const UserList = (props) => {
  const users = Object.keys(props.users).map((key) => props.users[key]);
  const listItems = users.sort((a,b)=> {return a.city>b.city?1:-1})
    .map((user) => {
      return (
        <div key={user.id} className="column is-5 is-narrow">
            <div className="box">
  <article className="media">
    <div className="media-left">
      <figure className="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image"/>
      </figure>
    </div>
    <div className="media-content">
      <div className="content">
      <h3 className="title">
              <Link
                to={`/user/${user.id}`}
              >
                {user.name}
              </Link>
            </h3>
            <p>Lives in { user.city}</p>
      </div>
      </div>
      </article>
      </div>
          
        </div>
      );
    });

  return listItems;
};

export default UserList;