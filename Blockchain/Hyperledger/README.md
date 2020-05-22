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
'{"Args": []}' -P "OR('Org1MSP.member', 'Org2MSP.member')" <br />
 docker exec -it cli peer chaincode invoke -o orderer.example.com:7050 -C channel12 -n mycc -c '{"Args":["assign","abcd","MIICGDCCAb+gAwIBAgIQcjE3mBcCnbHkIRXZ5+Y4GjAKBggqhkjOPQQDAjBzMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNU2FuIEZyYW5jaXNjbzEZMBcGA1UEChMQb3JnMi5leGFtcGxlLmNvbTEcMBoGA1UEAxMTY2Eub3JnMi5leGFtcGxlLmNvbTAeFw0yMDA1MjIwOTUyMDBaFw0zMDA1MjAwOTUyMDBaMFsxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1TYW4gRnJhbmNpc2NvMR8wHQYDVQQDDBZVc2VyMUBvcmcyLmV4YW1wbGUuY29tMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAENnKscjI4WahbmUz0aspN7dKJ1XL2qF+IlUm3VPSZjs4E8pK5+zWH8OepE4RjsXmFMbPId84EI84UFCrx4EdMVqNNMEswDgYDVR0PAQH/BAQDAgeAMAwGA1UdEwEB/wQCMAAwKwYDVR0jBCQwIoAgCkmHV6C/JmknmSjEMRnjyfYmj8E/ev5o+JeRQ8XU3CowCgYIKoZIzj0EAwIDRwAwRAIgKMKwutovx258+YachLTKD4BsPcldzolzEY13iyJYpEECIG3+0ULurumDGylZPv2OQwRYxWYhRzbHz8cBn+5vYNpZ"]}' <br />
 docker exec -it cli peer chaincode query -C channel12 -n mycc -c '{"Args":["read","abcd"]}' <br />
  docker exec -it cli peer chaincode invoke -o orderer.example.com:7050 -C channel12 -n mycc -c '{"Args":["transfer","abcd","MIICGjCCAcCgAwIBAgIRAO6XbeuEMAJNPDh+DOgZwT4wCgYIKoZIzj0EAwIwczELMAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExFjAUBgNVBAcTDVNhbiBGcmFuY2lzY28xGTAXBgNVBAoTEG9yZzEuZXhhbXBsZS5jb20xHDAaBgNVBAMTE2NhLm9yZzEuZXhhbXBsZS5jb20wHhcNMjAwNTIyMDk1MjAwWhcNMzAwNTIwMDk1MjAwWjBbMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNU2FuIEZyYW5jaXNjbzEfMB0GA1UEAwwWVXNlcjFAb3JnMS5leGFtcGxlLmNvbTBZMBMGByqGSM49AgEGCCqGSM49AwEHA0IABHHB5S9IqSWcnz7/1pTqmYE6tFlM1poSudlovwzpFsjRVXcJ0lDzEkdEOeHlRIkwjOhCzA2PODsb+7nsR8UVDaOjTTBLMA4GA1UdDwEB/wQEAwIHgDAMBgNVHRMBAf8EAjAAMCsGA1UdIwQkMCKAII21K29UJGJ4lYOKODamiBTOulMCPzO6rsuwI8img+8aMAoGCCqGSM49BAMCA0gAMEUCIQCVDi1gGFemMz2LDRUFDA/4MmFRxj/NkKhOsdD6qdtiGAIgOmWZLqywGn09sYxn5WvH4iWmzT6FnGujzHeMcUmziFQ="]}' <br />
  docker exec -it cli peer chaincode query -C channel12 -n mycc -c '{"Args":["read","abcd"]}' <br />
