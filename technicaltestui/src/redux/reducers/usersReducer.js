const usersReducer = (state = {}, action) => {
    switch (action.type) {
      case "FETCH_USERS":
        return action.payload.users.reduce((obj, user) => {
          obj[user.id] = user;
          return obj;
        }, {});
      case "FETCH_USER":
        return { ...state, [action.payload.user.id]: action.payload.user };
      default:
        return state;
    }
  };
  export default usersReducer;