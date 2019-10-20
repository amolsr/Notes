pragma solidity ^0.5.12;
contract add {
    uint public c;
    function Add(uint a, uint b) public {
        c=a+b;
    }
    function returnAdd() public view returns (uint) {
        return c;
    }
}