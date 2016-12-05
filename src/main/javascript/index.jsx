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
  constructor (props) {
    super()
    this.state = {
      category: {
        currentCategory: 1,
        categoriesLoaded: false,
        categories: []
      },
      list: {
        posts: [],
        postsLoaded: false
      },
      post: {
        postData: null,
        postLoaded: false
      }
    }

    this.state.category.categories = $.getJSON('/board/list', (data) => {
      this.state.category.categories = data
      this.state.category.categoriesLoaded = true
      this.setState(this.state)
    })

    this.changeCategory = ((_this) => {
      return (e) => {
        let category = e.target.value

        _this.state.category.currentCategory = category
        _this.state.list.posts = $.getJSON('/board/post/' + category, (data) => {
          _this.state.list.posts = data
          _this.state.list.postsLoaded = true
          _this.setState(_this.state)
        })
        _this.state.list.postsLoaded = false

        _this.setState(_this.state)
      }
    })(this)

    this.listOnClick = ((_this) => {
      return (postId, b) => {
        _this.state.post.postData = _this.state.list.posts = $.getJSON('/post/' + postId, (data) => {
          _this.state.post.postData = data
          _this.state.post.postLoaded = true
          _this.setState(_this.state)
        })
        _this.state.post.postLoaded = false
        _this.setState(_this.state)
      }
    })(this)
  }
  render () {
    return (
      <div>
        <Category onChange={this.changeCategory}
                  categoriesLoaded={this.state.category.categoriesLoaded}
                  currentCategory={this.state.category.currentCategory}
                  categories={this.state.category.categories} />
        <Post postData={this.state.post.postData}
              postLoaded={this.state.post.postLoaded} />
        <List onClick={this.listOnClick}
              posts={this.state.list.posts}
              postsLoaded={this.state.list.postsLoaded} />
      </div>
    )
  }
}

ReactDOM.render(<App />, document.getElementById('app'))
