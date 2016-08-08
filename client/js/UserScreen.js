import React, { PropTypes } from 'react';
import {add} from './actions';
import ChartScreen from './ChartScreen';
export default class UserScreen extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      currentUser: {}
    };
  }

  render() {
    return (
      <div id="pageContainer">
        <main id="mainContainer">
          {this.renderForm()}
          {this.renderUserList()}
          <ChartScreen refUsers={this.props.refUsers}/>
        </main>
      </div>
    );
  }

  renderForm() {
    return (
      <form onSubmit={this.onSubmit.bind(this)}>
        <div>
          <input type="text" tabIndex="1"
              onChange={this.onFormValueChangeHelper('name')}
              value={this.state.currentUser.name}
              placeholder="Name"/>
          <input type="text" tabIndex="2"
                onChange={this.onFormValueChangeHelper('email')}
                value={this.state.currentUser.email}
                placeholder="Email"/>
          <button>Save data</button>
          <button className="no-print" onClick={this.generatePdf.bind(this)}>PDF</button>
        </div>
      </form>
    );
  }

  generatePdf() {
    window.print();
  }

  renderUserList() {
    return (
      <ul>
        {
          this.props.refUsers.map(u =>
            <li key={u.id}>
              <label>{u.id}</label>
              <label>{u.name}</label>
              <label>{u.email}</label>
            </li>
          )
        }
      </ul>
    );
  }

  onSubmit(e) {
    e.preventDefault();
    add(this.state.currentUser);
  }

  onFormValueChangeHelper(field) {
    return e => {
      const val = e.target.value;
      this.setState({
        currentUser: Object.assign(
          {},
          this.state.currentUser,
          { [field]: val }
        )
      });
    };
  }
}

UserScreen.propTypes = {
  refUsers: PropTypes.array.isRequired
};
