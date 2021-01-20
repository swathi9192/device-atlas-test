import api from "../../api";

const fetchUsers = (users) => {
  return { type: "FETCH_USERS", payload: { users } };
};

const fetchUser = (user) => {
  return {
    type: "FETCH_USER",
    payload: {
      user,
    },
  };
};

export const loadUsers = () => async (dispatch) => {
  const res = await api.get(`users`);
  dispatch(fetchUsers(res.data));
};

export const loadUser = (id) => async (dispatch) => {
  
  const res = await api.get(`user/${id}`);
  dispatch(fetchUser(res.data));
  
};