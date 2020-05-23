https://medium.com/@kctheservant/demo-of-three-node-two-channel-setup-in-hyperledger-fabric-54ba8a9c461f

 ../bin/cryptogen generate --config=./crypto-config.yaml <br />
 ../bin/configtxgen -profile TwoOrgsOrdererGenesis -outputBlock ./channel-artifacts/genesis.block <br />
 ../bin/configtxgen -profile Channel -outputCreateChannelTx ./channel-artifacts/channel.tx -channelID channel12 <br />
 cd deployment/  <br />
 docker-compose -f docker-compose-orderer.yml up -d <br />
 docker-compose -f docker-compose-node1.yml up -d <br />
 docker-compose -f docker-compose-node2.yml up -d <br />
 docker exec -e "CORE_PEER_MSPCONFIGPATH=/var/hyperledger/users/Admin@org1.example.com/msp" peer0.org1.example.com peer channel create -o orderer.example.com:7050 -c channel12 -f /var/hyperledger/configs/channel.tx <br />
 docker cp peer0.org1.example.com:channel12.block . <br />
 docker exec -it peer0.org1.example.com ls <br />
 docker cp channel12.block peer0.org2.example.com:/channel12.block <br />
 docker exec -e "CORE_PEER_MSPCONFIGPATH=/var/hyperledger/users/Admin@org2.example.com/msp" peer0.org2.example.com peer channel join -b channel12.block <br />
 docker exec -it cli peer chaincode install -n mycc -p github.com/chaincode/ATA -v v0 <br />
 docker exec -it cli peer chaincode instantiate -o orderer.example.com:7050 -C channel12 -n mycc github.com/chaincode/ATA -v v0 -c 
'{"Args": []}' -P "OR('Org1MSP.client', 'Org2MSP.client')" <br />
 docker exec -it cli peer chaincode invoke -o orderer.example.com:7050 -C channel12 -n mycc -c '{"Args":["assign","abcd","Org2MSP"]}' <br />
 docker exec -it cli peer chaincode query -C channel12 -n mycc -c '{"Args":["read","abcd"]}' <br />
  docker exec -it cli peer chaincode invoke -o orderer.example.com:7050 -C channel12 -n mycc -c '{"Args":["transfer","abcd","Org1MSP"]}' <br />
  docker exec -it cli peer chaincode query -C channel12 -n mycc -c '{"Args":["read","abcd"]}' <br />
