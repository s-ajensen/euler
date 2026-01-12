cmake_minimum_required(VERSION 3.14)
project(euler_cpp)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include(FetchContent)
FetchContent_Declare(
    Catch2
    GIT_REPOSITORY https://github.com/catchorg/Catch2.git
    GIT_TAG v3.5.2
)
FetchContent_MakeAvailable(Catch2)

file(GLOB PROBLEM_FILES src/problems/*.cpp)
foreach(problem_file ${PROBLEM_FILES})
    get_filename_component(problem_name ${problem_file} NAME_WE)
    add_executable(${problem_name} ${problem_file})
endforeach()

file(GLOB_RECURSE TEST_FILES spec/*.cpp)

add_executable(tests ${TEST_FILES})
target_include_directories(tests PRIVATE ${CMAKE_SOURCE_DIR}/src)
target_link_libraries(tests PRIVATE Catch2::Catch2WithMain)

include(CTest)
include(Catch)
catch_discover_tests(tests)