<p align="center">
    <a href="https://travis-ci.org/badges/shields">
        <img src="https://img.shields.io/travis/badges/shields.svg"
             alt="build status">
    </a>
</p>
Implementation of the Silver Bars Market In-memory Order Board.
Only dependency required is Java 8.
Solution is not thread safe, this must be a client side implementation - i.e control access via putting this behind a ring buffer