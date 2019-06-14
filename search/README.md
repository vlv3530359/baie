1. Start up the elasticsearch cluster
    1. 启动node1
    cd /Users/vlv/Documents/ES/elasticsearch-6.5.4-1/bin
    ./elasticsearch
    2. 启动node2
    cd /Users/vlv/Documents/ES/elasticsearch-6.5.4-2/bin
    ./elasticsearch
    3. 启动node3
    cd /Users/vlv/Documents/ES/elasticsearch-6.5.4-3/bin
    ./elasticsearch
    4. 启动head
    cd /Users/vlv/Documents/ES/elasticsearch-head-master
    npm run start

2. Run test case

issues:
1. ElasticSearch ClusterBlockException[blocked by: [FORBIDDEN/12/index read-only / allow delete (api)];
   
http://127.0.0.1:9200/_all/_settings/  put
{"index.blocks.read_only_allow_delete": null}
