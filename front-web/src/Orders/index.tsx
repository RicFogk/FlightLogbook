import './styles.css';
import {ReactComponent as Logo} from './logo.svg';
import React from 'react';
import StepsHeader from './StepsHeader';

function Orders(){
    return(
        <div className="orders-container">
            <StepsHeader/>
        </div>
    )
}

export default  Orders;