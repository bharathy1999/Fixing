
module.exports = {
  devServer: {
    proxy: {
      '/signin': {
        target: 'http://localhost:8005', 
        changeOrigin: true, 
        pathRewrite: {
          '^/signin': '/SecureWebApp/receive', 
        },
      },
      '/signup': {
        target: 'http://localhost:8005/SecureWebApp', 
        changeOrigin: true, 
        pathRewrite: {
          '^/signup': '/SecureWebApp/getprof', 
        },
      },
    },
  },
};
