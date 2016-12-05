/**
  * Created by bjh970913 on 05/12/2016.
  * spring-board
  */
import $ from 'jquery'
window.$ = $

import React from 'react'
import ReactDOM from 'react-dom'

import List from './component/List.jsx'
import Post from './component/Post.jsx'
import Category from './component/Category.jsx'

class App extends React.Component {
  render () {
    return (
      <div>
        <Category />
        <Post />
        <List />
      </div>
    )
  }
}

ReactDOM.render(<App />, document.getElementById('app'))
