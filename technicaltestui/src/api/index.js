import axios from "axios";

const apiInstance = axios.create({
  baseURL: `http://localhost:8081`,
});

export default apiInstance;