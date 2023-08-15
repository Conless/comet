@.str = constant [3 x i8] c"%s\00"
@.str.1 = constant [4 x i8] c"%s\0A\00"
@.str.2 = constant [3 x i8] c"%d\00"
@.str.3 = constant [4 x i8] c"%d\0A\00"

define void @print(ptr %0) {
  %2 = alloca ptr
  store ptr %0, ptr %2
  %3 = load ptr, ptr %2
  %4 = call i32 (ptr, ...) @printf(ptr @.str, ptr %3)
  ret void
}

declare i32 @printf(ptr, ...)

define void @println(ptr %0) {
  %2 = alloca ptr
  store ptr %0, ptr %2
  %3 = load ptr, ptr %2
  %4 = call i32 (ptr, ...) @printf(ptr @.str.1, ptr %3)
  ret void
}

define void @printInt(i32 %0) {
  %2 = alloca i32
  store i32 %0, ptr %2
  %3 = load i32, ptr %2
  %4 = call i32 (ptr, ...) @printf(ptr @.str.2, i32 %3)
  ret void
}

define void @printlnInt(i32 %0) {
  %2 = alloca i32
  store i32 %0, ptr %2
  %3 = load i32, ptr %2
  %4 = call i32 (ptr, ...) @printf(ptr @.str.3, i32 %3)
  ret void
}

define ptr @getString() {
  %1 = alloca ptr
  %2 = load ptr, ptr %1
  %3 = call i32 (ptr, ...) @scanf(ptr @.str, ptr %2)
  %4 = load ptr, ptr %1
  ret ptr %4
}

declare i32 @scanf(ptr, ...)

define i32 @getInt() {
  %1 = alloca i32
  %2 = call i32 (ptr, ...) @scanf(ptr @.str.2, ptr %1)
  %3 = load i32, ptr %1
  ret i32 %3
}

define ptr @toString(i32 %0) {
  %2 = alloca i32
  %3 = alloca ptr
  store i32 %0, ptr %2
  %4 = load ptr, ptr %3
  %5 = load i32, ptr %2
  %6 = call i32 (ptr, ptr, ...) @sprintf(ptr %4, ptr @.str.2, i32 %5)
  %7 = load ptr, ptr %3
  ret ptr %7
}

declare i32 @sprintf(ptr, ptr, ...)

define ptr @__array_alloca(i32 %0, i32 %1) {
  %3 = alloca i32
  %4 = alloca i32
  %5 = alloca ptr
  store i32 %0, ptr %3
  store i32 %1, ptr %4
  %6 = load i32, ptr %4
  %7 = add nsw i32 %6, 1
  %8 = mul i32 4, %7
  %9 = call ptr @malloc(i32 %8)
  store ptr %9, ptr %5
  %10 = load i32, ptr %4
  %11 = load ptr, ptr %5
  %12 = getelementptr inbounds i32, ptr %11, i32 0
  store i32 %10, ptr %12
  %13 = load ptr, ptr %5
  %14 = getelementptr inbounds i32, ptr %13, i32 1
  ret ptr %14
}

declare ptr @malloc(i32)

define i32 @__array_size(ptr %0) {
  %2 = alloca ptr
  store ptr %0, ptr %2
  %3 = load ptr, ptr %2
  %4 = getelementptr inbounds i32, ptr %3, i32 -1
  %5 = load i32, ptr %4
  ret i32 %5
}

define i32 @__string_length(ptr %0) {
  %2 = alloca ptr
  %3 = alloca i32
  store ptr %0, ptr %2
  store i32 0, ptr %3
  br label %4

4:                                                ; preds = %11, %1
  %5 = load ptr, ptr %2
  %6 = load i32, ptr %3
  %7 = getelementptr inbounds i8, ptr %5, i32 %6
  %8 = load i8, ptr %7
  %9 = zext i8 %8 to i32
  %10 = icmp ne i32 %9, 0
  br i1 %10, label %11, label %14

11:                                               ; preds = %4
  %12 = load i32, ptr %3
  %13 = add nsw i32 %12, 1
  store i32 %13, ptr %3
  br label %4

14:                                               ; preds = %4
  %15 = load i32, ptr %3
  ret i32 %15
}

define ptr @__string_substring(ptr %0, i32 %1, i32 %2) {
  %4 = alloca ptr
  %5 = alloca i32
  %6 = alloca i32
  %7 = alloca i32
  %8 = alloca ptr
  %9 = alloca i32
  store ptr %0, ptr %4
  store i32 %1, ptr %5
  store i32 %2, ptr %6
  %10 = load i32, ptr %6
  %11 = load i32, ptr %5
  %12 = sub nsw i32 %10, %11
  store i32 %12, ptr %7
  %13 = load i32, ptr %7
  %14 = add nsw i32 %13, 1
  %15 = mul i32 1, %14
  %16 = call ptr @malloc(i32 %15)
  store ptr %16, ptr %8
  store i32 0, ptr %9
  br label %17

17:                                               ; preds = %31, %3
  %18 = load i32, ptr %9
  %19 = load i32, ptr %7
  %20 = icmp slt i32 %18, %19
  br i1 %20, label %21, label %34

21:                                               ; preds = %17
  %22 = load ptr, ptr %4
  %23 = load i32, ptr %5
  %24 = load i32, ptr %9
  %25 = add nsw i32 %23, %24
  %26 = getelementptr inbounds i8, ptr %22, i32 %25
  %27 = load i8, ptr %26
  %28 = load ptr, ptr %8
  %29 = load i32, ptr %9
  %30 = getelementptr inbounds i8, ptr %28, i32 %29
  store i8 %27, ptr %30
  br label %31

31:                                               ; preds = %21
  %32 = load i32, ptr %9
  %33 = add nsw i32 %32, 1
  store i32 %33, ptr %9
  br label %17

34:                                               ; preds = %17
  %35 = load ptr, ptr %8
  %36 = load i32, ptr %7
  %37 = getelementptr inbounds i8, ptr %35, i32 %36
  store i8 0, ptr %37
  %38 = load ptr, ptr %8
  ret ptr %38
}

define i32 @__string_parseInt(ptr %0) {
  %2 = alloca ptr
  %3 = alloca i32
  %4 = alloca i32
  store ptr %0, ptr %2
  store i32 0, ptr %3
  store i32 0, ptr %4
  %5 = load ptr, ptr %2
  %6 = getelementptr inbounds i8, ptr %5, i32 0
  %7 = load i8, ptr %6
  %8 = zext i8 %7 to i32
  %9 = icmp eq i32 %8, 45
  br i1 %9, label %10, label %11

10:                                               ; preds = %1
  store i32 1, ptr %4
  br label %11

11:                                               ; preds = %10, %1
  br label %12

12:                                               ; preds = %29, %11
  %13 = load ptr, ptr %2
  %14 = load i32, ptr %4
  %15 = getelementptr inbounds i8, ptr %13, i32 %14
  %16 = load i8, ptr %15
  %17 = zext i8 %16 to i32
  %18 = icmp ne i32 %17, 0
  br i1 %18, label %19, label %32

19:                                               ; preds = %12
  %20 = load i32, ptr %3
  %21 = mul nsw i32 %20, 10
  %22 = load ptr, ptr %2
  %23 = load i32, ptr %4
  %24 = getelementptr inbounds i8, ptr %22, i32 %23
  %25 = load i8, ptr %24
  %26 = zext i8 %25 to i32
  %27 = add nsw i32 %21, %26
  %28 = sub nsw i32 %27, 48
  store i32 %28, ptr %3
  br label %29

29:                                               ; preds = %19
  %30 = load i32, ptr %4
  %31 = add nsw i32 %30, 1
  store i32 %31, ptr %4
  br label %12

32:                                               ; preds = %12
  %33 = load ptr, ptr %2
  %34 = getelementptr inbounds i8, ptr %33, i32 0
  %35 = load i8, ptr %34
  %36 = zext i8 %35 to i32
  %37 = icmp eq i32 %36, 45
  br i1 %37, label %38, label %41

38:                                               ; preds = %32
  %39 = load i32, ptr %3
  %40 = sub nsw i32 0, %39
  store i32 %40, ptr %3
  br label %41

41:                                               ; preds = %38, %32
  %42 = load i32, ptr %3
  ret i32 %42
}

define i32 @__string_ord(ptr %0, i32 %1) {
  %3 = alloca ptr
  %4 = alloca i32
  store ptr %0, ptr %3
  store i32 %1, ptr %4
  %5 = load ptr, ptr %3
  %6 = load i32, ptr %4
  %7 = getelementptr inbounds i8, ptr %5, i32 %6
  %8 = load i8, ptr %7
  %9 = zext i8 %8 to i32
  ret i32 %9
}

define i32 @__string_compare(ptr %0, ptr %1) {
  %3 = alloca i32
  %4 = alloca ptr
  %5 = alloca ptr
  %6 = alloca i32
  store ptr %0, ptr %4
  store ptr %1, ptr %5
  store i32 0, ptr %6
  br label %7

7:                                                ; preds = %47, %2
  %8 = load ptr, ptr %4
  %9 = load i32, ptr %6
  %10 = getelementptr inbounds i8, ptr %8, i32 %9
  %11 = load i8, ptr %10
  %12 = zext i8 %11 to i32
  %13 = icmp ne i32 %12, 0
  br i1 %13, label %14, label %21

14:                                               ; preds = %7
  %15 = load ptr, ptr %5
  %16 = load i32, ptr %6
  %17 = getelementptr inbounds i8, ptr %15, i32 %16
  %18 = load i8, ptr %17
  %19 = zext i8 %18 to i32
  %20 = icmp ne i32 %19, 0
  br label %21

21:                                               ; preds = %14, %7
  %22 = phi i1 [ false, %7 ], [ %20, %14 ]
  br i1 %22, label %23, label %50

23:                                               ; preds = %21
  %24 = load ptr, ptr %4
  %25 = load i32, ptr %6
  %26 = getelementptr inbounds i8, ptr %24, i32 %25
  %27 = load i8, ptr %26
  %28 = zext i8 %27 to i32
  %29 = load ptr, ptr %5
  %30 = load i32, ptr %6
  %31 = getelementptr inbounds i8, ptr %29, i32 %30
  %32 = load i8, ptr %31
  %33 = zext i8 %32 to i32
  %34 = icmp ne i32 %28, %33
  br i1 %34, label %35, label %47

35:                                               ; preds = %23
  %36 = load ptr, ptr %4
  %37 = load i32, ptr %6
  %38 = getelementptr inbounds i8, ptr %36, i32 %37
  %39 = load i8, ptr %38
  %40 = zext i8 %39 to i32
  %41 = load ptr, ptr %5
  %42 = load i32, ptr %6
  %43 = getelementptr inbounds i8, ptr %41, i32 %42
  %44 = load i8, ptr %43
  %45 = zext i8 %44 to i32
  %46 = sub nsw i32 %40, %45
  store i32 %46, ptr %3
  br label %62

47:                                               ; preds = %23
  %48 = load i32, ptr %6
  %49 = add nsw i32 %48, 1
  store i32 %49, ptr %6
  br label %7

50:                                               ; preds = %21
  %51 = load ptr, ptr %4
  %52 = load i32, ptr %6
  %53 = getelementptr inbounds i8, ptr %51, i32 %52
  %54 = load i8, ptr %53
  %55 = zext i8 %54 to i32
  %56 = load ptr, ptr %5
  %57 = load i32, ptr %6
  %58 = getelementptr inbounds i8, ptr %56, i32 %57
  %59 = load i8, ptr %58
  %60 = zext i8 %59 to i32
  %61 = sub nsw i32 %55, %60
  store i32 %61, ptr %3
  br label %62

62:                                               ; preds = %50, %35
  %63 = load i32, ptr %3
  ret i32 %63
}

define ptr @__string_concat(ptr %0, ptr %1) {
  %3 = alloca ptr
  %4 = alloca ptr
  %5 = alloca i32
  %6 = alloca i32
  %7 = alloca ptr
  %8 = alloca i32
  %9 = alloca i32
  store ptr %0, ptr %3
  store ptr %1, ptr %4
  %10 = load ptr, ptr %3
  %11 = call i32 @__string_length(ptr %10)
  store i32 %11, ptr %5
  %12 = load ptr, ptr %4
  %13 = call i32 @__string_length(ptr %12)
  store i32 %13, ptr %6
  %14 = load i32, ptr %5
  %15 = load i32, ptr %6
  %16 = add nsw i32 %14, %15
  %17 = add nsw i32 %16, 1
  %18 = mul i32 1, %17
  %19 = call ptr @malloc(i32 %18)
  store ptr %19, ptr %7
  store i32 0, ptr %8
  br label %20

20:                                               ; preds = %32, %2
  %21 = load i32, ptr %8
  %22 = load i32, ptr %5
  %23 = icmp slt i32 %21, %22
  br i1 %23, label %24, label %35

24:                                               ; preds = %20
  %25 = load ptr, ptr %3
  %26 = load i32, ptr %8
  %27 = getelementptr inbounds i8, ptr %25, i32 %26
  %28 = load i8, ptr %27
  %29 = load ptr, ptr %7
  %30 = load i32, ptr %8
  %31 = getelementptr inbounds i8, ptr %29, i32 %30
  store i8 %28, ptr %31
  br label %32

32:                                               ; preds = %24
  %33 = load i32, ptr %8
  %34 = add nsw i32 %33, 1
  store i32 %34, ptr %8
  br label %20

35:                                               ; preds = %20
  store i32 0, ptr %9
  br label %36

36:                                               ; preds = %50, %35
  %37 = load i32, ptr %9
  %38 = load i32, ptr %6
  %39 = icmp slt i32 %37, %38
  br i1 %39, label %40, label %53

40:                                               ; preds = %36
  %41 = load ptr, ptr %4
  %42 = load i32, ptr %9
  %43 = getelementptr inbounds i8, ptr %41, i32 %42
  %44 = load i8, ptr %43
  %45 = load ptr, ptr %7
  %46 = load i32, ptr %5
  %47 = load i32, ptr %9
  %48 = add nsw i32 %46, %47
  %49 = getelementptr inbounds i8, ptr %45, i32 %48
  store i8 %44, ptr %49
  br label %50

50:                                               ; preds = %40
  %51 = load i32, ptr %9
  %52 = add nsw i32 %51, 1
  store i32 %52, ptr %9
  br label %36

53:                                               ; preds = %36
  %54 = load ptr, ptr %7
  %55 = load i32, ptr %5
  %56 = load i32, ptr %6
  %57 = add nsw i32 %55, %56
  %58 = getelementptr inbounds i8, ptr %54, i32 %57
  store i8 0, ptr %58
  %59 = load ptr, ptr %7
  ret ptr %59
}

define void @__string_copy(ptr %0, ptr %1) {
  %3 = alloca ptr
  %4 = alloca ptr
  %5 = alloca i32
  %6 = alloca i32
  store ptr %0, ptr %3
  store ptr %1, ptr %4
  %7 = load ptr, ptr %4
  %8 = call i32 @__string_length(ptr %7)
  store i32 %8, ptr %5
  store i32 0, ptr %6
  br label %9

9:                                                ; preds = %21, %2
  %10 = load i32, ptr %6
  %11 = load i32, ptr %5
  %12 = icmp slt i32 %10, %11
  br i1 %12, label %13, label %24

13:                                               ; preds = %9
  %14 = load ptr, ptr %4
  %15 = load i32, ptr %6
  %16 = getelementptr inbounds i8, ptr %14, i32 %15
  %17 = load i8, ptr %16
  %18 = load ptr, ptr %3
  %19 = load i32, ptr %6
  %20 = getelementptr inbounds i8, ptr %18, i32 %19
  store i8 %17, ptr %20
  br label %21

21:                                               ; preds = %13
  %22 = load i32, ptr %6
  %23 = add nsw i32 %22, 1
  store i32 %23, ptr %6
  br label %9

24:                                               ; preds = %9
  %25 = load ptr, ptr %3
  %26 = load i32, ptr %5
  %27 = getelementptr inbounds i8, ptr %25, i32 %26
  store i8 0, ptr %27
  ret void
}
