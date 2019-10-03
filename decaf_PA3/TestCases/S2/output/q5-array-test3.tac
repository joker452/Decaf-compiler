VTABLE(_Father) {
    <empty>
    Father
    _Father.foo;
}

VTABLE(_Child) {
    _Father
    Child
    _Father.foo;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Father_New) {
memo ''
_Father_New:
    _T1 = 8
    parm _T1
    _T2 =  call _Alloc
    _T3 = 0
    *(_T2 + 4) = _T3
    _T4 = VTBL <_Father>
    *(_T2 + 0) = _T4
    return _T2
}

FUNCTION(_Child_New) {
memo ''
_Child_New:
    _T5 = 12
    parm _T5
    _T6 =  call _Alloc
    _T7 = 0
    *(_T6 + 4) = _T7
    *(_T6 + 8) = _T7
    _T8 = VTBL <_Child>
    *(_T6 + 0) = _T8
    return _T6
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T9 = 4
    parm _T9
    _T10 =  call _Alloc
    _T11 = VTBL <_Main>
    *(_T10 + 0) = _T11
    return _T10
}

FUNCTION(_Father.foo) {
memo '_T0:4'
_Father.foo:
    _T12 = *(_T0 + 4)
    return _T12
}

FUNCTION(main) {
memo ''
main:
    _T15 = *(_T13 - 4)
    _T17 = 4
    _T18 = (_T17 * _T15)
    _T19 = 0
_L14:
    _T20 = (_T13 + _T19)
    _T16 = *(_T20 + 0)
    _T19 = (_T19 + _T17)
    _T21 = 2
    _T22 = (_T14 > _T21)
    if (_T22 == 0) branch _L13
    parm _T16
    _T24 = *(_T16 + 0)
    _T25 = *(_T24 + 8)
    _T26 =  call _T25
    _T23 = _T26
    _T27 = (_T19 < _T18)
    if (_T27 == 0) branch _L13
    branch _L14
_L13:
}

