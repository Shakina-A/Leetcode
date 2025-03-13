/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    // Handle edge cases
    if (head == NULL || head->next == NULL) {
        return head;
    }
    
    struct ListNode* dummy = malloc(sizeof(struct ListNode));
    dummy->next = head;
    struct ListNode* prev = dummy;
    struct ListNode* current = head;
    struct ListNode* next = head->next;
    
    while (current != NULL && next != NULL) {
        // Swap current and next nodes
        prev->next = next;
        current->next = next->next;
        next->next = current;
        
        // Move pointers forward for the next pair
        prev = current;
        current = current->next;
        if (current != NULL) {
            next = current->next;
        }
    }
    
    head = dummy->next;
    free(dummy);
    
    return head;
}