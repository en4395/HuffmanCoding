# Huffman Coding tree
A tree that matches the structure given in "Data Structures and Algorithms" Assignment 2

OVERVIEW:
This huffman coding tree was programmed to match the structure provided in the assignment.

NOTES ON STRUCTURE AND PRIORITY:
When there is no hierarchy among nodes of the same frequency/weight, a min heap may be used to build the tree, as there is no need for a stable structure. 
However the goal of the assignment was to work out the how priority among nodes of the same frequency was established, then program an 
appropriate data structure which observed this priority. 

In my assignment, nodes of the same weight were sorted by their order of appearance in the text file. To respect this, I performed an initial stable sort
(radix sort) on the single-node huffman trees, then used a queue which performed an insertion sort to reinsert the nodes into the tree. 
