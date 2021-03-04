
import { url } from '../core/constant';

const performLogin = (email, password, dispatch) => {

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Access-Control-Allow-Origin": "*",
            "Accept": "application/json",
        },
        body: JSON.stringify({ userName: email, password })
    };
    fetch(url.loginUrl, requestOptions)
        .then(response => response.json())
        .then(data => {
            dispatch({
                type: 'Login',
                serviceType: data.type
            })
        });
}

export {
    performLogin
}