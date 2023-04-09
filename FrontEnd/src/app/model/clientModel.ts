import { Tour } from "./tourModel";

export class Client {
    userId:any;
    firstName:string;
    lastName:string;
    email:string;
    phoneNumber:string;
    role!:string;
    password:string;
    address!:string;
    tour!:Tour;
    constructor(){
        this.firstName="";
        this.lastName="";
        this.email="";
        this.phoneNumber="";
        this.password="";}

}