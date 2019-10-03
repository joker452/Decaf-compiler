VTABLE(_Father) {
    <empty>
    Father
    _Father.method;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Father_New) {
memo ''
_Father_New:
    _T2 = 8
    parm _T2
    _T3 =  call _Alloc
    _T4 = 0
    *(_T3 + 4) = _T4
    _T5 = VTBL <_Father>
    *(_T3 + 0) = _T5
    return _T3
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T6 = 4
    parm _T6
    _T7 =  call _Alloc
    _T8 = VTBL <_Main>
    *(_T7 + 0) = _T8
    return _T7
}

FUNCTION(_Father.method) {
memo '_T0:4 _T1:8'
_Father.method:
    _T9 = 0
    _T10 = (_T1 > _T9)
    _T11 = 10
    _T12 = (_T1 < _T11)
    _T13 = (_T10 && _T12)
    if (_T13 == 0) branch _L12
    _T14 = 3
    _T15 = (_T1 - _T14)
    _T1 = _T15
    parm _T0
    parm _T1
    _T16 = *(_T0 + 0)
    _T17 = *(_T16 + 8)
    _T18 =  call _T17
    return _T18
_L12:
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T21 =  call _Father_New
    _T20 = _T21
    _T22 =  call _Father_New
    _T19 = _T22
    _T23 = *(_T20 + 4)
    *(_T19 + 4) = _T23
}

