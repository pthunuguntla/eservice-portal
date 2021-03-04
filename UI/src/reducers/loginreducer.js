export default function loginReducer(state = {}, action) {
    switch (action.type) {
        case 'Login': {
            return {
                serviceType: action.serviceType
            }
        }

        default: {
            return state
        }
    }
}