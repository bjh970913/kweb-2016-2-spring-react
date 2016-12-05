/**
  * Created by bjh970913 on 05/12/2016.
  * spring-board
  */
let path = require('path')
let srcMain = path.join(__dirname, 'src/main/javascript')

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
        test: /\.jsx$/,
        loader: 'babel',
        exclude: /node_modules/,
        options: {
          cacheDirectory: true,
          presets: ['es2015', 'react']
        }
      }
    ]
  }
}
