import React from 'react'

class Post extends React.Component {

  render () {
    if (this.props.postLoaded) {
      return (
        <div>
          <h2>{this.props.postData.title}</h2>
          <h3>{this.props.postData.board.name}</h3>
          <h4>{this.props.postData.author.email}</h4>
          <p>{this.props.postData.content}</p>
        </div>
      )
    }
    return false
  }
}

export default Post
