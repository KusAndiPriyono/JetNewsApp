# Keep all fields and members of classes in Gson and SQLCipher
-keep,includedescriptorclasses class net.sqlcipher.** { *; }
-keep,includedescriptorclasses interface net.sqlcipher.** { *; }
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
# Keep all fields and members of classes in your package
-keep class com.bangkit.jetnewsapp.database.model.** { *; }
-keep class com.google.gson.internal.LinkedTreeMap { *; }

# Retrofit and Gson integration
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.bangkit.jetnewsapp.network.model.NewsResponse { *; }

# Keep classes and members needed by Gson
-keepattributes Signature
-keepattributes *Annotation*
-keepclassmembers class com.google.gson.examples.android.model.** { <fields>; }
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.google.gson.reflect.TypeToken
-keep class * extends com.google.gson.reflect.TypeToken
-keep public class * implements java.lang.reflect.Type
-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken
-keepattributes AnnotationDefault

# Retrofit-specific rules
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore warnings about specific packages
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*
-dontwarn kotlinx.**

# Keep Retrofit interfaces and their subtypes
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>
-keep,allowobfuscation interface * extends <1>

# Keep other classes needed by Retrofit and Gson
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-keep,allowoptimization,allowshrinking,allowobfuscation class <3>
-keep,allowobfuscation,allowshrinking class retrofit2.Response

# Keep required classes for Gson InstanceCreators
-keepclassmembers class * {
    public <init>();
    public <init>(...);
}
-keepclassmembers class * implements com.google.gson.InstanceCreator {
    <init>(...);
}
