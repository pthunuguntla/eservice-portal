import React, { PureComponent, Fragment } from 'react';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';

import { performLogin } from '../../actions/loginAction';

import { serviceTypeMap } from '../../core/constant';
import Admin from '../Admin';
import Customer from '../Customer';

import './Login.css';

const emailPlaceHolder = "Enter Email";
const passowrdPlaceHolder = "Enter Password";

const mapStateToProps = state => {
    const serviceType = state.loginreducer.serviceType;
    return {
        serviceType,
    }
};

const mapDispatchToProps = dispatch => ({
    performLoginAction: (email, password) => {
        performLogin(email, password, dispatch)
    },
});

class Login extends PureComponent {

    static propTypes = { 
        serviceType: PropTypes.string,
        performLoginAction: PropTypes.func
    }

    static defaultProps = {
        serviceType: '',
    }

    state= {
        email : '',
        password: '',
    }

    onChange = (e, stateLabel) => {
        this.setState({
            [stateLabel]: e.target.value
        })
    }



    onClick = () => {
        const { email, password } = this.state;
        this.props.performLoginAction(email, password);
    }


    render() {
        const { serviceType } = this.props;
        return (
            <Fragment>
                {(serviceType === '' || serviceType === null) && (
                    <Fragment>
                    <h1 className= "WelcomeHeader" >Welcome to E-Service Portal</h1>
                    <div className="Login">
                    <input
                        type="text"
                        onChange={(e) => this.onChange(e, 'email')}
                        placeholder={emailPlaceHolder}
                        name = "Email"
                        className="UserName"
                    />
                    <input
                        type="password"
                        placeholder={passowrdPlaceHolder}
                        onChange={(e) => this.onChange(e, 'password')}
                        name="Password"
                        className="Password"
                    />
                    <button onClick={this.onClick} className="Proceed">Proceed to login</button>
                    {serviceType === null && <h3 className="">Please Enter Correct UserName and Password To Proceed</h3>}
                 </div>
                 </Fragment>
                )}

                {serviceType === serviceTypeMap.admin && <Admin /> }
                {serviceType === serviceTypeMap.customer && <Customer /> }
            </Fragment>
        )
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Login);
