export const getUsers = (state) => {
    return state.users;
  };
  
  export const getUser = (state, id) => {
    return state.users[id];
  };
  