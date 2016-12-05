import React from 'react'
import $ from 'jquery'

class List extends React.Component {
  render () {
    let trs = []
    if (this.props.postsLoaded) {
      trs = this.props.posts.map((obj) => {
        return (
          <tr onClick={
            (
              function (a, event) {
                this.props.onClick(a, event)
              }
            ).bind(this, obj.id)}>
            <td>{obj.id}</td>
            <td>{obj.author.email}</td>
            <td>{obj.title}</td>
          </tr>
        )
      })
    }
    return (
      <table>
        <thead>
          <th>id</th>
          <th>작성자</th>
          <th>제목</th>
        </thead>
        <tbody>
          {trs}
        </tbody>
      </table>
    )
  }
}

export default List
