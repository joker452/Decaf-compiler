VTABLE(_Father) {
    <empty>
    Father
    _Father.method;
}

VTABLE(_Child) {
    _Father
    Child
    _Father.method;
    _Child.start;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Father_New) {
memo ''
_Father_New:
    _T3 = 8
    parm _T3
    _T4 =  call _Alloc
    _T5 = 0
    *(_T4 + 4) = _T5
    _T6 = VTBL <_Father>
    *(_T4 + 0) = _T6
    return _T4
}

FUNCTION(_Child_New) {
memo ''
_Child_New:
    _T7 = 8
    parm _T7
    _T8 =  call _Alloc
    _T9 = 0
    *(_T8 + 4) = _T9
    _T10 = VTBL <_Child>
    *(_T8 + 0) = _T10
    return _T8
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T11 = 4
    parm _T11
    _T12 =  call _Alloc
    _T13 = VTBL <_Main>
    *(_T12 + 0) = _T13
    return _T12
}

FUNCTION(_Father.method) {
memo '_T0:4 _T1:8'
_Father.method:
    _T14 = 0
    _T15 = (_T1 > _T14)
    _T16 = 10
    _T17 = (_T1 < _T16)
    _T18 = (_T15 && _T17)
    if (_T18 == 0) branch _L14
    _T19 = 3
    _T20 = (_T1 - _T19)
    _T1 = _T20
    parm _T0
    parm _T1
    _T21 = *(_T0 + 0)
    _T22 = *(_T21 + 8)
    _T23 =  call _T22
    return _T23
_L14:
    return _T1
}

FUNCTION(_Child.start) {
memo '_T2:4'
_Child.start:
    _T24 = _T2
    _T25 = *(_T24 + 4)
    _T26 = 5
    *(_T24 + 4) = _T26
    _T27 = 0
    _T24 = _T27
    _T28 = *(_T2 + 4)
    parm _T28
    call _PrintInt
}

FUNCTION(main) {
memo ''
main:
}

