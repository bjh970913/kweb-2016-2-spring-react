import React from 'react'

class Post extends React.Component {
  render () {
    return (
      <div>
        <h2>{this.props.title}</h2>
        <h3>{this.props.board.name}</h3>
        <h4>{this.props.author.email}</h4>
        <p>{this.props.content}</p>
      </div>
    )
  }
}

export default Post
