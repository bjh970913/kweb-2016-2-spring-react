/**
 * Created by bjh970913 on 05/12/2016.
 */
let React = require('react')
let ReactDOM = require('react-dom')

function Item (props) {
  return (<li>{props.message}</li>);
}

function TodoList () {
  const todos = ['finish doc', 'submit p', 'nag dan to review']
  return (
    <ul>
      {todos.map((message) => <Item key={message} message={message} />)}
    </ul>
  )
}

ReactDOM.render(<TodoList />, document.getElementById('app'))
