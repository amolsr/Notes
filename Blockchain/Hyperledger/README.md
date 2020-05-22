https://medium.com/@kctheservant/demo-of-three-node-two-channel-setup-in-hyperledger-fabric-54ba8a9c461f

 ../bin/cryptogen generate --config=./crypto-config.yaml <br />
 ../bin/configtxgen -profile TwoOrgsOrdererGenesis -outputBlock ./channel-artifacts/genesis.block <br />
 ../bin/configtxgen -profile Channel -outputCreateChannelTx ./channel-artifacts/channel.tx -channelID channel <br />
 cd deployment/  <br />
 docker-compose -f docker-compose-orderer.yml up -d <br />
 docker-compose -f docker-compose-node1.yml up -d <br />
 docker-compose -f docker-compose-node2.yml up -d <br />
