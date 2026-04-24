# Answers.md

## Part 1:

Shared Resource #1: nextId
Shared Resource #2: requests
Concurrency Problem: Race Condition - multiple threads may read the same value of nextId before any thread increments it, leading to duplicate IDs.
Why addRequest() is unsafe: It performs a check-then-act operation on nextId and modifies the non-thread-safe ArrayList without synchronization, which can lead to data corruption or ConcurrentModificationException.

## Part 2:

Fix A: Incorrect. While getNextId() becomes thread-safe, addRequest() still accesses the requests list (an ArrayList) which is not thread-safe. Multiple threads could still corrupt the list during the add() operation.
Fix B: Correct. By synchronizing addRequest(), you ensure that only one thread at a time can calculate the ID and modify the list. This creates an atomic operation for the entire request process.
Fix C: Incorrect. This only synchronizes the retrieval of the list reference. It does nothing to protect the nextId counter or the list during the add process.

## Part 3:

No. According to Riel’s heuristics, "Users of a class should not rely on its implementation details." getNextId() is an internal mechanism for generating unique identifiers for the RequestManager. Making it public allows external classes to interfere with the ID sequence, violating encapsulation.

## Part 4:

Description:
Atomic Variables like AtomicInteger and Concurrent Collections like CopyOnWriteArrayList use low-level "Compare-And-Swap" (CAS) operations to ensure thread safety without the heavy overhead of the synchronized lock.

Code Snippet:
private AtomicInteger nextId = new AtomicInteger(1);
private List<String> requests = new CopyOnWriteArrayList<>();

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    requests.add("Request-" + id + " from " + studentName);
}
