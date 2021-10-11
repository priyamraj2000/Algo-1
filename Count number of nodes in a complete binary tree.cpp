#include <bits/stdc++.h>
using namespace std;

class node {
public:
	int data;
	node* left;
	node* right;
};

node* newNode(int data);

int left_height(node* node)
{
	int ht = 0;
	while (node) {
		ht++;
		node = node->left;
	}

	return ht;
}

int right_height(node* node)
{
	int ht = 0;
	while (node) {
		ht++;
		node = node->right;
	}

	return ht;
}

int TotalNodes(node* root)
{

	// Base Case
	if (root == NULL)
		return 0;

	int lh = left_height(root);
	int rh = right_height(root);

	if (lh == rh)
		return (1 << lh) - 1;

	return 1 + TotalNodes(root->left)
		+ TotalNodes(root->right);
}

node* newNode(int data)
{
	node* Node = new node();
	Node->data = data;
	Node->left = NULL;
	Node->right = NULL;
	return (Node);
}

int main()
{
	node* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(9);
	root->right->right = newNode(8);
	root->left->left->left = newNode(6);
	root->left->left->right = newNode(7);

	cout << TotalNodes(root);

	return 0;
}

