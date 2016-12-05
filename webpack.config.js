/**
 * Created by bjh970913 on 05/12/2016.
 */
var path = require('path')

var srcMain = path.join(__dirname, 'src/main/javascript')

module.exports = {
  entry: {
    index: path.join(srcMain, 'index.jsx')
  },
  output: {
    path: path.join(__dirname, 'src/main/resources/static/js'),
    filename: '[name].bundle.js',
    chunkFilename: '[id].bundle.js'
  },
  module: {
    loaders: [
      {
        test: path.join(__dirname, '.'),
        exclude: /(node_modules)/,
        loader: 'jsx-loader'
      }
    ]
  }
};
