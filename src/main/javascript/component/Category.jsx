import React from 'react'
import $ from 'jquery'
class Category extends React.Component {
  render () {
    let options = []
    if (this.props.categoriesLoaded) {
      options = this.props.categories.map((obj) => {
        return (
          <option value={obj.id} key={obj.id}>{obj.name}</option>
        )
      })
    }
    return (
      <div>
        <select onChange={this.props.onChange} value={this.props.currentCategory}>
          {options}
        </select>
      </div>
    )
  }
}

export default Category
