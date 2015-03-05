# BloomFilter

This simple app implements a bloom filter. A Bloom filter is a space-efficient probabilistic data structure, 
conceived by Burton Howard Bloom in 1970, that is used to test whether an element is a member of a set. False 
positive matches are possible, but false negatives are not, thus a Bloom filter has a 100% recall rate. In other 
words, a query returns either "possibly in set" or "definitely not in set".

Such filters are heavily used in anti-viruses to check for malicious URLs. Anti-viruses have these bloom filters
which test the URL being tried to access and if the test gives a positive, then the software contacts the servers
to check if that URL is in fact malicious, since it might also be a false positive.
