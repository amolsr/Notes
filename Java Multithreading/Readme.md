# Difference Between HashMap, Hashtable, and ConcurrentHashMap

This document explains the differences between **HashMap**, **Hashtable**, and **ConcurrentHashMap** in Java.

---

## 🔹 1. HashMap
- **Thread Safety**: ❌ Not synchronized, not thread-safe. Multiple threads can cause data inconsistency.  
- **Performance**: ✅ Faster than `Hashtable` and `ConcurrentHashMap` in **single-threaded** applications.  
- **Nulls**: ✅ Allows **one null key** and **multiple null values**.  
- **Iteration**: Uses **fail-fast iterator** (throws `ConcurrentModificationException` if the map is modified while iterating).  
- **Use Case**: Best for **non-threaded applications** where speed matters.  

---

## 🔹 2. Hashtable
- **Thread Safety**: ✅ **Synchronized** → every method is synchronized. Thread-safe, but blocks entire table for every operation.  
- **Performance**: ❌ Slower than `HashMap` because of **synchronization overhead**.  
- **Nulls**: ❌ **No null key, no null values** allowed.  
- **Iteration**: Uses **enumerator** (legacy) and also **fail-fast iterators** when using `entrySet`/`keySet`.  
- **Legacy**: Considered **obsolete**, kept for backward compatibility.  
- **Use Case**: Rarely used today; replaced by `ConcurrentHashMap` for multi-threaded environments.  

---

## 🔹 3. ConcurrentHashMap
- **Thread Safety**: ✅ Thread-safe with **better concurrency** than `Hashtable`.  
   - Instead of locking the whole map, it uses **segment-based locking** (Java 7) or **bucket-level CAS-based updates** (Java 8).  
- **Performance**: ✅ Much faster than `Hashtable` in multi-threaded environments.  
- **Nulls**: ❌ **No null keys and no null values** allowed (to avoid ambiguity in concurrent settings).  
- **Iteration**: Uses **fail-safe iterators** (does not throw `ConcurrentModificationException` while iterating, but may not reflect the most recent updates).  
- **Use Case**: Best for **highly concurrent, multi-threaded applications**.  

---

## ⚡ Quick Comparison Table

| Feature               | HashMap              | Hashtable            | ConcurrentHashMap    |
|------------------------|----------------------|----------------------|----------------------|
| Thread-Safe            | ❌ No               | ✅ Yes (synchronized) | ✅ Yes (fine-grained locking / CAS) |
| Performance            | ✅ Fastest (single-threaded) | ❌ Slow (full map lock) | ✅ High concurrency |
| Null Key               | ✅ 1 allowed        | ❌ Not allowed        | ❌ Not allowed        |
| Null Values            | ✅ Multiple allowed | ❌ Not allowed        | ❌ Not allowed        |
| Iterator               | Fail-fast           | Fail-fast / Enumerator | Fail-safe           |
| Legacy or Modern       | Modern (Java 1.2+) | Legacy (Java 1.0)    | Modern (Java 5+)     |

---

## 👉 Summary
- Use **HashMap** → For single-threaded applications.  
- Use **ConcurrentHashMap** → For multi-threaded applications.  
- Avoid **Hashtable** → It’s legacy and less efficient.  
